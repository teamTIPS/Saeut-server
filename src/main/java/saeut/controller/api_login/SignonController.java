package saeut.controller.api_login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import saeut.domain.Account;
import saeut.service.facade.MyPageFacade;

@RestController
public class SignonController {

	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping(value = "/signon.do/{id}", method = RequestMethod.POST)
	public ResponseEntity<Account> signOn(@PathVariable("id") String id, @PathVariable("password") String password,
			HttpServletRequest request){
		
		ResponseEntity<Account>  resEntity = null; //로그인이 안되면 널값이 넘어가는거 익셉션 주의하기 
		Account account = myPageFacade.getAccountByUserIdAndPassword(id, password);
		
		if (account == null) { //다시 리다이렉트하거나 메세지를 띄어주거나 로그인 성공하지 못한거 처리해주기  
			//return 모바일 login url; 					
		}else {  //로그인 성공하면 account 정보를 넘겨줌  
			HttpSession session = request.getSession();
			session.setAttribute("id", id);	//사용자 로그인 아이디 세션에 유지 -> 어디서 invalidate할지 다시 체크 
			
			resEntity =  new ResponseEntity<Account>(account, HttpStatus.OK);
		}
				
		return resEntity;
	}
	

}
