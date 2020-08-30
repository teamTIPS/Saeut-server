package saeut.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


import saeut.domain.Demand;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/demand")
public class DemandController {
	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Demand> findDemand (@PathVariable("id") String id) {
		
		Demand demand = myPageFacade.getDemandByUserId(id);
		
		return new ResponseEntity(demand,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Demand>> findAllDemand () {
		
		List<Demand> demands = myPageFacade.getAllDemand();
		
		return new ResponseEntity(demands,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addDemand (@RequestBody Demand demand) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.insertDemand(demand);
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	//수정하기
	@RequestMapping(value = "/mod", method = RequestMethod.PUT)
	public ResponseEntity<String> modDemand (@RequestBody Demand demand) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.modDemand(demand);
			resEntity =new ResponseEntity("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	//삭제하기
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeDemand (@PathVariable("id") String id) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.removeDemand(id);
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	
	
	

}
