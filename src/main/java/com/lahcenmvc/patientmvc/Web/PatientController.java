package com.lahcenmvc.patientmvc.Web;

import com.lahcenmvc.patientmvc.Entities.Patient;
import com.lahcenmvc.patientmvc.Repositrories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientRepository patientRepository ;

    @GetMapping()
    public @ResponseBody
    Iterable<Patient>
    getAllPatients(){
        return patientRepository.findAll();
    }


}
