package saeut.controller.api_login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import saeut.domain.Account;
import saeut.domain.LoginInfo;
import saeut.security.AuthenticationResponse;
import saeut.security.CommonException;
import saeut.security.Jwt;
import saeut.security.JwtComponent;
import saeut.service.facade.MyPageFacade;


@RestController
@RequestMapping("/signon")
public class SignonController {  
//	로그인 및 회원가입 컨트롤러 
//	sign in : 로그인 , sign up : 회원가입
//	
	@Autowired
	private MyPageFacade myPageFacade;
	@Autowired
	private JwtComponent jwtUtil;
	
	
	@PostMapping("/signon")   
	public ResponseEntity<AuthenticationResponse> signIn (@RequestBody LoginInfo loginInfo) throws CommonException{ 
		ResponseEntity<AuthenticationResponse> resEntity = null;
		Account account_result = myPageFacade.getAccountByUserIdAndPassword(loginInfo);
	
		if (account_result == null) { 
				resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {  
			try { 
				// 로그인 성공 시 토큰 생성 후 Response에 담아 전송
				Jwt token = this.jwtUtil.makeJwt(loginInfo.getId(), loginInfo.getPassword());
				resEntity = ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(token));
			}catch(Exception e) {
				resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
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
		int account_result = myPageFacade.isDuplicated(loginInfo);
		if (account_result == 1) // 중복된 아이디 존재 시 false 반환 
			resEntity = ResponseEntity.status(HttpStatus.OK).body("false");			
		else  // 중복된 아이디가 없을 시 true 반환
			resEntity = ResponseEntity.status(HttpStatus.OK).body("true");
		return resEntity;
	}	

	
	
	
}
	
