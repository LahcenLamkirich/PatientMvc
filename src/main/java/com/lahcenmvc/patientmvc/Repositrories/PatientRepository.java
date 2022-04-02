package com.lahcenmvc.patientmvc.Repositrories;

import com.lahcenmvc.patientmvc.Entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>{
     Page<Patient> findByNameContains(String keyword, Pageable pageable) ;
}