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
import saeut.domain.Board;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private MyPageFacade mypageFacade;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<List<Board>> findBoardById (@PathVariable("id") String id) {
		
		List<Board> posts = mypageFacade.getBoardByUserId(id);
		
		return new ResponseEntity<List<Board>>(posts,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Board>> findAllBoard () {
		
		List<Board> posts = mypageFacade.getAllBoard();

		return new ResponseEntity<List<Board>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("post/{post_id}")
	public ResponseEntity<List<Board>> findBoardByPost_id (@PathVariable("post_id") int post_id) {
		
		List<Board> posts = mypageFacade.getBoardByPost_id(post_id);
		
		return new ResponseEntity<List<Board>>(posts,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addBoard (@RequestBody Board board) {
		ResponseEntity<String>  resEntity = null;
		try {
			mypageFacade.insertBoard(board);
			resEntity =new ResponseEntity<String>("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	@PutMapping
	public ResponseEntity<String> modBoard (@RequestBody Board board) {
		ResponseEntity<String>  resEntity = null;
		try {
			mypageFacade.modBoard(board);
			resEntity =new ResponseEntity<String>("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	@DeleteMapping("/{post_id}")
	public ResponseEntity<String> removeBoard (@PathVariable("post_id") int post_id) {
		ResponseEntity<String>  resEntity = null;
		try {
			mypageFacade.removeBoard(post_id);
			resEntity =new ResponseEntity<String>("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
}
