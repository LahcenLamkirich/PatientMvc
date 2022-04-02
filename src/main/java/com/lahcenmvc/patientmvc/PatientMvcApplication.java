package com.lahcenmvc.patientmvc;

import com.lahcenmvc.patientmvc.Entities.Patient;
import com.lahcenmvc.patientmvc.Repositrories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class PatientMvcApplication implements CommandLineRunner{
    @Autowired
    PatientRepository patientRepository ;
    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<Patient> list = (ArrayList<Patient>) patientRepository.findAll();
        for(int i = 1 ; i < list.size(); i++){
            System.out.println(list.get(i).getName());
        }

    }

}
