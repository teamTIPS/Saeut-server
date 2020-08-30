package saeut.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import saeut.domain.Account;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Account> findAccount (@PathVariable("id") String id) {
		
		Account account = myPageFacade.getAccountByUserId(id);
		
		return new ResponseEntity(account,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> findAccountByType(@PathVariable("type") int type) {
		
		List<Account> accounts = myPageFacade.getAllAccount();
		List<Account> result = null;
		
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getType() == type) {
				result.add(i, accounts.get(i));
			}else {
				continue;
			}
		}
		if(result == null) {
			//return new ResponseEntity("typeError",HttpStatus.OK));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@RequestMapping(value = "/nick/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> findNickname (@PathVariable("id") String id) {
		
		String nickname = myPageFacade.getNicknameByUserID(id);
		 HttpHeaders responseHeaders = new HttpHeaders();
		 responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity(nickname,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addArticle (@RequestBody Account account) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.insertAccount(account);
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	//수정하기
	@RequestMapping(value = "/mod", method = RequestMethod.PUT)
	public ResponseEntity<String> modArticle (@RequestBody Account account) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.modAccount(account);
			resEntity =new ResponseEntity("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	//삭제하기
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeArticle (@PathVariable("id") String id) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.removeAccount(id);
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
}
