package com.lahcenmvc.patientmvc.Web;

import com.lahcenmvc.patientmvc.Repositrories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PatientController {

    private PatientRepository patientRepository ;

    // l'injection de depandance avec le constructeur
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("")
    public String getAllPatients(){
        return "patients";
    }


}
