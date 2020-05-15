 package com.capgemini.hcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hcm.dao.DiagnosticCenterDao;
import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.entity.Tests;

@Transactional
@Service
public class DiagnosticCenterService {
	
	
	@Autowired
	private DiagnosticCenterDao diagnosticCenterDao;
	
	
	public boolean addcenter(DiagnosticCenter diagnosticcenter)
	{
		return diagnosticCenterDao.save(diagnosticcenter) != null;
	}
	
	
	public List<DiagnosticCenter> listallcenter()
	{
		return diagnosticCenterDao.findAll();
	}
	
	
	
	public void deletecenter( Integer centerId)
	{
		diagnosticCenterDao.deleteById(centerId);
	}
	
	
	public boolean updatecenter(DiagnosticCenter diagnosticcenter,Integer centerId)
	{
		diagnosticcenter.setCenterName(diagnosticcenter.getCenterName());
		return diagnosticCenterDao.save(diagnosticcenter) != null;
	}
	
	
}
