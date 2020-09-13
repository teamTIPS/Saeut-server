package saeut.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import saeut.domain.UserEssential;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/UserEssential")
public class UserEssentialController {
	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<UserEssential>> findAllUserEssential () {
		
		List<UserEssential> list = myPageFacade.getAllUserEssential();
		
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserEssential> findUserEssential (@PathVariable("id") String id) {
		
		UserEssential UserEssential = myPageFacade.getUserEssentialByUserId(id);
		
		if(!(UserEssential==null))
			return new ResponseEntity(UserEssential,HttpStatus.OK);
		else
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<UserEssential>> findUserEssentialByType(@PathVariable("type") int type) {
		
		List<UserEssential> UserEssentials = myPageFacade.getAllUserEssential();
		List<UserEssential> result = null;
		
		for(int i = 0; i < UserEssentials.size(); i++) {
			if(UserEssentials.get(i).getType() == type) {
				result.add(i, UserEssentials.get(i));
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
	public ResponseEntity<String> addArticle (@RequestBody UserEssential UserEssential) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.insertUserEssential(UserEssential);
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	//수정하기
	@RequestMapping(value = "/mod", method = RequestMethod.PUT)
	public ResponseEntity<String> modArticle (@RequestBody UserEssential UserEssential) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.modUserEssential(UserEssential);
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
			myPageFacade.removeUserEssential(id);
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
}
