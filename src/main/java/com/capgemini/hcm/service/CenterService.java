 package com.capgemini.hcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hcm.dao.CenterRepo;
import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.entity.Tests;

@Service
public class CenterService {
	
	@Autowired
	private CenterRepo centerrepo;
	
	@Transactional
	public boolean addcenter(DiagnosticCenter diagnosticcenter)
	{
		return centerrepo.save(diagnosticcenter) != null;
	}
	
	@Transactional
	public List<DiagnosticCenter> show()
	{
		return centerrepo.findAll();
	}
	
	@Transactional
	
	public void deletecenter(DiagnosticCenter diagnosticcenter)
	{
		centerrepo.delete(diagnosticcenter);
	}
	
	@Transactional
	public DiagnosticCenter updatecenter(DiagnosticCenter diagnosticcenter,String centerId)
	{
		return centerrepo.save(diagnosticcenter);
	}
	
	
}
