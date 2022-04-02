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
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class PatientMvcApplication {
    @Autowired
    PatientRepository patientRepository ;
    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {
            patientRepository.save(new Patient(null,"Lahcen", new Date(), false, 255));
            patientRepository.save(new Patient(null,"Hassan", new Date(), false, 120));
            patientRepository.save(new Patient(null,"Yassine", new Date(), true, 562));
            patientRepository.save(new Patient(null,"Khaled", new Date(), false, 780));
            patientRepository.save(new Patient(null,"Rabii", new Date(), true, 128));
        };
    }


}
