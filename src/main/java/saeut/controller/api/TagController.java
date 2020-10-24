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
import saeut.domain.Tag;
import saeut.service.facade.PostFacade;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
	private PostFacade postFacade;
	
	@GetMapping
	public ResponseEntity<List<Tag>> findAllTag () {
		
		List<Tag> tags = postFacade.getAllTag();

		return new ResponseEntity<List<Tag>>(tags,HttpStatus.OK);
	}
	
	@GetMapping("/{post_id}")
	public ResponseEntity<List<Tag>> findPostByPost_id (@PathVariable("post_id") int post_id) {
		
		List<Tag> tags = postFacade.getTagByPostID(post_id);
		
		return new ResponseEntity<List<Tag>>(tags,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addTag (@RequestBody Tag tag) {
		ResponseEntity<String>  resEntity = null;
		try {
			postFacade.insertTag(tag);
			resEntity =new ResponseEntity<String>("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	@DeleteMapping("/{post_id}")
	public ResponseEntity<String> removeArticle (@PathVariable("post_id") int post_id) {
		ResponseEntity<String>  resEntity = null;
		try {
			postFacade.removeTag(post_id);
			resEntity =new ResponseEntity<String>("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
}
