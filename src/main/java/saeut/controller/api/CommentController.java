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
import saeut.domain.Comment;
import saeut.service.facade.PostFacade;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private PostFacade postFacade;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Comment>> findCommentById (@PathVariable("id") String id) {
		
		List<Comment> comments = postFacade.getCommentByUserId(id);
		
		return new ResponseEntity<List<Comment>>(comments,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Comment>> findAllComment () {
		
		List<Comment> comments = postFacade.getAllComment();

		return new ResponseEntity<List<Comment>>(comments,HttpStatus.OK);
	}
	
	@GetMapping("/group/{post_id}")
	public ResponseEntity<List<Comment>> findCommentByPostId (@PathVariable("post_id") int post_id) {
		
		List<Comment> comments = postFacade.getCommentByPostId(post_id);
		return new ResponseEntity<List<Comment>>(comments,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addComment (@RequestBody Comment comment) {
		ResponseEntity<String>  resEntity = null;
		try {
			postFacade.insertComment(comment);
			resEntity =new ResponseEntity<String>("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	@PutMapping
	public ResponseEntity<String> modComment (@RequestBody Comment comment) {
		ResponseEntity<String>  resEntity = null;
		try {
			postFacade.modComment(comment);
			resEntity =new ResponseEntity<String>("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeComment (@PathVariable("id") int comment_id) {
		ResponseEntity<String>  resEntity = null;
		try {
			postFacade.removeComment(comment_id);
			resEntity =new ResponseEntity<String>("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
}
