package saeut.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


import saeut.domain.Certificate;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Certificate>> findCertificate (@PathVariable("id") String id) {
		
		List<Certificate> certificates = myPageFacade.getCertificateByUserId(id);
		
		return new ResponseEntity(certificates,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Certificate>> findAllCertificate () {
		
		List<Certificate> certificates = myPageFacade.getAllCertificate();
		
		return new ResponseEntity(certificates,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addCertificate (@RequestBody Certificate certificate) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.insertCertificate(certificate);
			resEntity =new ResponseEntity("ADD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	//수정하기
	@RequestMapping(value = "/mod", method = RequestMethod.POST)
	public ResponseEntity<String> modCertificate (@RequestBody Certificate certificate) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.modCertificate(certificate);
			resEntity =new ResponseEntity("MOD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	//삭제하기
	@RequestMapping(value = "/remove/{cert_id}", method = RequestMethod.GET)
	public ResponseEntity<String> removeCertificate (@PathVariable("cert_id") int cert_id) {
		ResponseEntity<String>  resEntity = null;
		try {
			myPageFacade.removeCertificate(cert_id);
			resEntity =new ResponseEntity("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}	
	
	
	
	

}
