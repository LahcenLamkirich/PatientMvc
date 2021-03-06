package com.lahcenmvc.patientmvc.Web;

import com.lahcenmvc.patientmvc.Entities.Patient;
import com.lahcenmvc.patientmvc.Repositrories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String getAllPatients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "10") int size,
                                 @RequestParam(name= "keyword", defaultValue = "") String keyword){

        Page<Patient> patients = patientRepository.findByNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String Delete(Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/patientslist")
    @ResponseBody
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }

    @GetMapping("/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient", new Patient()) ;
        return "formPatients" ;
    }

    @GetMapping("/save")
    public String save(Model model, Patient patient){
        patientRepository.save(patient);
        System.out.println(patient);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String Edit(Model model, Long id){
        Patient patient = patientRepository.findById(id).get();
        model.addAttribute("patient", patient) ;
        return "editPatient";
    }

}
