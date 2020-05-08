package com.capgemini.hcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.hcm.entity.DiagnosticCenter;

public interface CenterRepo extends JpaRepository<DiagnosticCenter, String>{


}
