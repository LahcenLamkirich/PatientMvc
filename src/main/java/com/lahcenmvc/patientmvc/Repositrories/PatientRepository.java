package com.lahcenmvc.patientmvc.Repositrories;

import com.lahcenmvc.patientmvc.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}