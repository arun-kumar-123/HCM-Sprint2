package com.capgemini.hcm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.exception.CenterException;
import com.capgemini.hcm.service.DiagnosticCenterService;
@CrossOrigin(origins="http://localhost:4200") 
@RestController
public class DiagnosticCenterController {

	@Autowired
	private DiagnosticCenterService diagnosticCenterService;

	@CrossOrigin
	@PostMapping("/addcenter")
	public ResponseEntity<String> addCenter(@Valid @RequestBody DiagnosticCenter diagnosticcenter, BindingResult br)
			throws CenterException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new CenterException(err);
		}
		try {
			diagnosticCenterService.addcenter(diagnosticcenter);
			return new ResponseEntity<String>("Center added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new CenterException("ID already exists");
		}
	}

	@CrossOrigin
	@GetMapping("/viewallcenter")
	public ResponseEntity<List<DiagnosticCenter>> getDiagnosticCenterlist() {
		List<DiagnosticCenter> diagnosticCenterList = diagnosticCenterService.listallcenter();
		return new ResponseEntity<List<DiagnosticCenter>>(diagnosticCenterList, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/deletecenter/{id}")
	public ResponseEntity<String> deletecenter(@Valid @RequestParam Integer centerId) throws CenterException
	{
		try
		{
			diagnosticCenterService.deletecenter( centerId);
			return new ResponseEntity<String>("Center is deleted", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new CenterException("Center ID doesnot exists");
		}
	}
	
	@CrossOrigin
	@PutMapping("/updatecenter/{id}")
	public ResponseEntity<String> updatecenter(@Valid @RequestBody DiagnosticCenter diagnosticcenter, @RequestParam Integer centerId,BindingResult br)throws CenterException
	{
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new CenterException(err);
		}
		try
		{
			diagnosticCenterService.updatecenter(diagnosticcenter, centerId);
			return new ResponseEntity<String>("Center added successfully", HttpStatus.OK);

		}
		catch (DataIntegrityViolationException ex) {
			throw new CenterException("Center ID doesnot exists");
		}
	}
}
