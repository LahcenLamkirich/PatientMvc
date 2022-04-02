package com.lahcenmvc.patientmvc.Web;

import com.lahcenmvc.patientmvc.Entities.Patient;
import com.lahcenmvc.patientmvc.Repositrories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class PatientController {

    private PatientRepository patientRepository ;

    // l'injection de depandance avec le constructeur
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("")
    public String getAllPatients(Model model){
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/all")
    public @ResponseBody String patient(){
        return "Test";
    }

}
