package saeut.controller.api_login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saeut.domain.LoginInfo;
import saeut.domain.UserEssential;
import saeut.domain.Auth;
import saeut.security.AuthenticationResponse;
import saeut.security.CommonException;
import saeut.security.Jwt;
import saeut.security.JwtComponent;
import saeut.security.JwtComponent.TOKEN_TYPE;
import saeut.service.facade.MyPageFacade;
import saeut.service.facade.AuthFacade;


@RestController
@RequestMapping("/signon")
public class SignonController {  
//	로그인 및 회원가입 컨트롤러  
	
	@Autowired
	private MyPageFacade myPageFacade;
	@Autowired
	private JwtComponent jwtUtil;
	@Autowired
	private AuthFacade authFacade;
	
	/*
	 * 1. 로그인 실패 시 BAD_REQUEST 리턴
	 * 2. 로그인 성공 시 
	 * 		2-1. access token과 refresh token발급 -> 디비에는 refresh token만을 저장 (그럼 매치를 어떻게..?)
	 * 		2-2. 클라이언트에게 at와 rt 응답 
	 * 		2-3. rt DB에 저장
	 */
	@PostMapping("/authenticate")   
	public ResponseEntity<AuthenticationResponse> signIn (@RequestBody LoginInfo loginInfo) throws CommonException{ 
		ResponseEntity<AuthenticationResponse> resEntity = null;
		UserEssential UserEssential_result = myPageFacade.getUserEssentialByUserIdAndPassword(loginInfo);
	
		if (UserEssential_result == null) { 
				resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {  
			try { 
				// 로그인 성공 시 토큰 생성 후 Response에 담아 전송 + 유저 정보까지 리턴하도록...
				Jwt token = this.jwtUtil.makeJwt(loginInfo.getId(), loginInfo.getPassword());
				resEntity = ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(token, UserEssential_result));
				// 성공한 아이디와 RT를 데이터베이스에 저장
				Auth auth = new Auth();
				auth.setId(loginInfo.getId());
				auth.setRefreshToken(token.getRefreshToken());
				auth.setRefreshToken_expiretime(this.jwtUtil.extractExpiration(token.getRefreshToken(), TOKEN_TYPE.REFRESH_TOKEN));
				if(authFacade.isDuplicated(loginInfo.getId())==0) {
					// 저장되어 있는 RT값이 없는 경우 신규 생성
					authFacade.insertAuth(auth);
				}
				else {
					// 이미 저장되어 있는 RT값이 존재하는 경우 새로운 RT정보값으로 수정
					authFacade.modAuth(auth);
				}
			}catch(Exception e) { 
				//로그인 실패 응답 시에 아이디가 문제인지 비번이 문제인지 아예 존재하지 않는 회원인지 구분해서 응답하기 
				resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
		}
		return resEntity;
	}
	
	/*
	 * access token의 만료시간이 다되어 "오류를 전달받은" 클라이언트가 요청하는 메소드이다. -> 만료 응답 .. 
	 * 이떄, 클라이언트는 refresh token을 이용하여 access token의 재발급을 요청한다.
	 * 서버는 유효한 refresh token으로 요청이 들어오면 -> 새로운 access token을 발급하여 응답한다.
	 * 만약 만료된 refresh token로 요청이 들어온다면 -> "오류를 반환"하여 사용자에게 새로 로그인을 요구한다.
	 * 
	 */
	@PostMapping( value = "/get_access_token")
	public ResponseEntity<AuthenticationResponse> get_access_token(@RequestBody Jwt jwt) throws Exception{
		// at, rt를 바디로 전달 ,, -> at와 rt 둘다 전달 왜? at는 해당 유저의 토큰인지 확인하기위함.... 
		// 일단 at로 해당 유저인것을 확인하지 않고 rt만 가지고  유저정보 불러오는데 수정필요할수도있는 부분 
		ResponseEntity<AuthenticationResponse> resEntity = null;
		String rt = jwt.getRefreshToken();
		String subject = this.jwtUtil.extractUsername(rt, TOKEN_TYPE.REFRESH_TOKEN);
		final UserDetails user = this.jwtUtil.getUserDetailService().loadUserByUsername(subject);
		
		Boolean isValid = this.jwtUtil.validateToken(rt, user, TOKEN_TYPE.REFRESH_TOKEN);
		if( isValid) { //유효하면 at만 재발행 
			Jwt token = this.jwtUtil.makeReJwt(rt);
			resEntity =  ResponseEntity.ok(new AuthenticationResponse(token));
			
		}else {// 만료되었을 때 
			resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return resEntity;
	}
		
	/*
	 *	Refresh Token의 만료 기간이 1/2남았을 때, Refresh Token을 update해준다.  
	 *  헤더에 at만 넘어옴 -> rt를 새로 발급해서 디비에 저장(원래 있던 rt update) 및 갱신한 rt 응답하기 
	 */
	@PostMapping( value = "/get_refresh_token")
	public ResponseEntity<AuthenticationResponse> get_refresh_token(
			@RequestHeader("Authorization") String at) throws Exception{
		//요청 : 헤더에 at를 전달해준다..바디는 널이다.. 
		ResponseEntity<AuthenticationResponse> resEntity = null;

		String subject = this.jwtUtil.extractUsername(at, TOKEN_TYPE.ACCESS_TOKEN);
		final UserDetails user = this.jwtUtil.getUserDetailService().loadUserByUsername(subject);
		
		try {
			Jwt token = this.jwtUtil.updateReJwt(at); 
			resEntity =  ResponseEntity.ok(new AuthenticationResponse(token));
		}catch(Exception e) { 
			resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return resEntity;
	}
	
	
	// JWT 토큰을 반환하는 호출(테스트용), (id, password) 형식으로 계정정보 전송 시 토큰 반환
	@PostMapping("/test")
	   public ResponseEntity<?> authenticate (@RequestBody LoginInfo loginInfo) throws CommonException, Exception{
	      
	      Jwt token = this.jwtUtil.makeJwt(loginInfo.getId(), loginInfo.getPassword());
	      return ResponseEntity.ok(  new AuthenticationResponse(token));
	   }
	
	@PostMapping("/checkid")
	public ResponseEntity<String> isDuplicated (@RequestBody LoginInfo loginInfo) { 
		ResponseEntity<String>  resEntity = null;
		int UserEssential_result = myPageFacade.isDuplicated(loginInfo);
		if (UserEssential_result == 1) // 중복된 아이디 존재 시 false 반환 
			resEntity = ResponseEntity.status(HttpStatus.OK).body("false");			
		else  // 중복된 아이디가 없을 시 true 반환
			resEntity = ResponseEntity.status(HttpStatus.OK).body("true");
		return resEntity;
	}	

	
	
	
}
	
