package saeut.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import saeut.domain.Post;
import saeut.service.facade.PostFacade;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostFacade postFacade;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findPostById (@PathVariable("id") String id) {
		
		List<Post> posts = postFacade.getPostByUserId(id);
		
		return new ResponseEntity(posts,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAllPost () {
		
		List<Post> posts = postFacade.getAllPost();
		
		return new ResponseEntity(posts,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addPost (@RequestBody Post post) {
		ResponseEntity<String>  resEntity = null;
		try {
			postFacade.insertPost(post);
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	//수정하기
	@RequestMapping(value = "/mod", method = RequestMethod.POST)
	public ResponseEntity<String> modPost (@RequestBody Post post) {
		ResponseEntity<String>  resEntity = null;
		try {
			postFacade.modPost(post);
			resEntity =new ResponseEntity("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	//삭제하기
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> removeArticle (@PathVariable("id") int id) {
		ResponseEntity<String>  resEntity = null;
		try {
			postFacade.removePost(id);
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
}
