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


import saeut.domain.Supply;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/supply")
public class SupplyController {
	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Supply> findSupply (@PathVariable("id") String id) {
		
		Supply supply = myPageFacade.getSupplyByUserId(id);
		
		return new ResponseEntity(supply,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Supply>> findAllSupply () {
		
		List<Supply> supplys = myPageFacade.getAllSupply();
		
		return new ResponseEntity(supplys,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addSupply (@RequestBody Supply supply) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.insertSupply(supply);
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	//수정하기
	@RequestMapping(value = "/mod", method = RequestMethod.PUT)
	public ResponseEntity<String> modSupply (@RequestBody Supply supply) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.modSupply(supply);
			resEntity =new ResponseEntity("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	//삭제하기
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeSupply (@PathVariable("id") String id) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.removeSupply(id);
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	
	
	

}
