package com.capgemini.hcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hcm.service.CenterService;

@RestController
public class CenterController {

	@Autowired
	private CenterService centerservice;
	

	
}
