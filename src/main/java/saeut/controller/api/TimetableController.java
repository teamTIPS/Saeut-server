package saeut.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import saeut.domain.Timetable;
import saeut.service.facade.TimetableFacade;

@RestController
@RequestMapping("/timetable")
public class TimetableController {
	
	@Autowired
	private TimetableFacade timetableFacade;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Timetable> findTimeByUserId(@PathVariable("id") String id) {
		
		List<Timetable> timetable = timetableFacade.getTimeListById(id);
		
		return new ResponseEntity(timetable, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addTimetable (@RequestBody Timetable timetable) {
		ResponseEntity<String>  resEntity = null;
		try {
			timetableFacade.insertTimetable(timetable);
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	@RequestMapping(value = "/mod", method = RequestMethod.PUT)
	public ResponseEntity<String> modPost (@RequestBody Timetable timetable) {
		ResponseEntity<String>  resEntity = null;
		try {
			timetableFacade.modTimetable(timetable);
			resEntity =new ResponseEntity("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeArticle (@PathVariable("id")String id) {
		ResponseEntity<String>  resEntity = null;
		try {
			timetableFacade.removeTimetableById(id);
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	


}
