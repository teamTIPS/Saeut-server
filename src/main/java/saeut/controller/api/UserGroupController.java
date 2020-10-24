package saeut.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import saeut.domain.UserGroup;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/usergroup")
public class UserGroupController {
	@Autowired
	private MyPageFacade mypageFacade;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<UserGroup>> findUserGroupById (@PathVariable("id") String id) {
		
		List<UserGroup> posts = mypageFacade.getUserGroupByUserId(id);
		
		return new ResponseEntity<List<UserGroup>>(posts,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserGroup>> findAllUserGroup () {
		
		List<UserGroup> groups = mypageFacade.getAllUserGroup();

		return new ResponseEntity<List<UserGroup>>(groups,HttpStatus.OK);
	}
	
	@GetMapping("/type/{type}")
	public ResponseEntity<List<UserGroup>> findUserGroupByType (@PathVariable("type") int type) {
		
		List<UserGroup> groups = mypageFacade.getUserGroupByType(type);
		
		return new ResponseEntity<List<UserGroup>>(groups,HttpStatus.OK);
	}
	
	@GetMapping("/post/{post_id}")
	public ResponseEntity<List<UserGroup>> findUserGroupByTitle (@PathVariable("post_id") int post_id) {
		
		List<UserGroup> groups = mypageFacade.getUserGroupByPost_id(post_id);
		
		return new ResponseEntity<List<UserGroup>>(groups,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<String> addUserGroup (@RequestBody UserGroup userGroup) {
		ResponseEntity<String>  resEntity = null;
		try {
			mypageFacade.insertUserGroup(userGroup);
			resEntity =new ResponseEntity<String>("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	@PutMapping
	public ResponseEntity<String> modUserGroup (@RequestBody UserGroup userGroup) {
		ResponseEntity<String>  resEntity = null;
		try {
			mypageFacade.modUserGroup(userGroup);
			resEntity =new ResponseEntity<String>("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeUserGroup (@PathVariable("id") String id) {
		ResponseEntity<String>  resEntity = null;
		try {
			mypageFacade.removeUserGroup(id);
			resEntity =new ResponseEntity<String>("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
}
