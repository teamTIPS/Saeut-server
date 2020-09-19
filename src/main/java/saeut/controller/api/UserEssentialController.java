package saeut.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import saeut.domain.UserEssential;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/user/essential")
public class UserEssentialController {
	@Autowired
	private MyPageFacade myPageFacade;
	

	@GetMapping("/{id}")
	public ResponseEntity<UserEssential> findUserEssential (@PathVariable("id") String id) {
		
		UserEssential UserEssential = myPageFacade.getUserEssentialByUserId(id);
		if(!(UserEssential==null))
			return new ResponseEntity<UserEssential>(UserEssential,HttpStatus.OK);
		else
			return new ResponseEntity<UserEssential>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/nickname/{id}")
	public ResponseEntity<String> findNickname (@PathVariable("id") String id) {
		
		 String nickname = myPageFacade.getNicknameByUserID(id);
		 HttpHeaders responseHeaders = new HttpHeaders();
		 responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		 return new ResponseEntity<String>(nickname,responseHeaders, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserEssential>> findAllUserEssential () {
		
		List<UserEssential> list = myPageFacade.getAllUserEssential();
		
		return new ResponseEntity<List<UserEssential>>(list,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addUser (@RequestBody UserEssential UserEssential) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.insertUserEssential(UserEssential);
			resEntity =new ResponseEntity<String>("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	@PutMapping
	public ResponseEntity<String> modUser (@RequestBody UserEssential UserEssential) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.modUserEssential(UserEssential);
			resEntity =new ResponseEntity<String>("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeUser (@PathVariable("id") String id) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.removeUserEssential(id);
			resEntity =new ResponseEntity<String>("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
}