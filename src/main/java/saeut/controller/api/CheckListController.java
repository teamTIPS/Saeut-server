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

import saeut.domain.CheckList;
import saeut.service.facade.PostFacade;

@RestController
@RequestMapping("/checklist")
public class CheckListController {
	@Autowired
	private PostFacade postFacade;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<CheckList>> findAllCheckList () {
		
		List<CheckList> checklist = postFacade.getAllCheckList();
		
		return new ResponseEntity(checklist,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/top6", method = RequestMethod.GET)
	public ResponseEntity<List<CheckList>> findTop6CheckList () {
		
		List<CheckList> checklist = postFacade.getTop6CheckList();
		
		return new ResponseEntity(checklist,HttpStatus.OK);
	}

	
}
