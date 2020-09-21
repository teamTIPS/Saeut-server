package saeut.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saeut.domain.Apply;
import saeut.service.facade.ApplyFacade;
import saeut.service.facade.PostFacade;


@RestController
@RequestMapping("/apply")
public class ApplyContorller {   //add , read, applyCount 
	
	@Autowired
	private ApplyFacade applyFacade;
	
	@Autowired
	private PostFacade postFacade;
	
	@GetMapping
	public ResponseEntity<List<Apply>> getAllApply () { 
	
		List<Apply> list = applyFacade.getAllApply();
		
		return new ResponseEntity<List<Apply>>(list, HttpStatus.OK);
	}	
	
	@GetMapping("/postId/{postId}")   //POST 기준으로 한 게시물당 APPLY 목록 
	public ResponseEntity<List<Apply>> getApplyByPostId (@PathVariable int postId) { 
		List<Apply> list = null;
		if(postFacade.isExistPostId(postId)) {
			list = applyFacade.getApplyByPostId(postId);
			return  new ResponseEntity<List<Apply>>(list, HttpStatus.OK);  
		}
		return  new ResponseEntity<List<Apply>>(list, HttpStatus.BAD_REQUEST);//null들어가는거 에러코드로 수정해야
	}	
	
	
	@GetMapping("/id/{id}")  //유저기준으로 자신이 신청한 APPLY 목록  
	public ResponseEntity<List<Apply>> getApplyByUserId (@PathVariable String id) { 
	
		List<Apply> list = applyFacade.getApplyByUserId(id);
		
		return new ResponseEntity<List<Apply>>(list, HttpStatus.OK);
	}	
	
	
	@PostMapping
	public ResponseEntity<String> addApply (@RequestBody Apply apply){ 
		ResponseEntity<String>  resEntity = null;
		try { //작성자 자신이 스스로 신청 못하게 하기 & 신청중복으로 못함 
			if(applyFacade.isAlreadyApply(apply.getId(), apply.getPost_id())) {
				resEntity =new ResponseEntity<String>("You have already applied",HttpStatus.BAD_REQUEST);
			}else if(applyFacade.isVaildId(apply.getId(), apply.getPost_id())) {
				applyFacade.insertApply(apply);
				resEntity =new ResponseEntity<String>("ADD_SUCCEEDED",HttpStatus.OK);
			}else {
				resEntity =new ResponseEntity<String>("Cannot apply their own",HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	
	
	@GetMapping("/count/{postId}")  
	public ResponseEntity<Integer> getApplyCount(@PathVariable int postId) {  
		if(postFacade.isExistPostId(postId)) {
			int count = applyFacade.getApplyCount(postId);
			return new ResponseEntity<Integer>(count, HttpStatus.OK);
		}
		return new ResponseEntity<Integer>(-1, HttpStatus.BAD_REQUEST); //유효하지 않은 post_id일때 -> 에러 코드 보완 
	}	
	
	
	
}
