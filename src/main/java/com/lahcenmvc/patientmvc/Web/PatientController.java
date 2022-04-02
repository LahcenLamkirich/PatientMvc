package com.lahcenmvc.patientmvc.Web;

import com.lahcenmvc.patientmvc.Repositrories.PatientRepository;
import org.springframework.stereotype.Controller;

@Controller
public class PatientController {

    private PatientRepository patientRepository ;

    // l'injection de depandance avec le constructeur
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    

}
