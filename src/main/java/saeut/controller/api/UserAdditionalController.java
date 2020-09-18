package saeut.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


import saeut.domain.UserAdditional;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/user/additional")
public class UserAdditionalController {
	@Autowired
	private MyPageFacade myPageFacade;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserAdditional> findUserAdditional (@PathVariable("id") String id) {
		
		UserAdditional UserAdditional = myPageFacade.getUserAdditionalByUserId(id);
		
		return new ResponseEntity(UserAdditional,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserAdditional>> findAllUserAdditional () {
		
		List<UserAdditional> UserAdditionals = myPageFacade.getAllUserAdditional();
		
		return new ResponseEntity(UserAdditionals,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addUserAdditional (@RequestBody UserAdditional UserAdditional) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.insertUserAdditional(UserAdditional);
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	

	@PutMapping
	public ResponseEntity<String> modUserAdditional (@RequestBody UserAdditional UserAdditional) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.modUserAdditional(UserAdditional);
			resEntity =new ResponseEntity("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeUserAdditional (@PathVariable("id") String id) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.removeUserAdditional(id);
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}	
	
}
