package com.spring.petclinic.bootstrap;

import com.spring.childclinic.model.Doctor;
import com.spring.childclinic.model.Parent;
import com.spring.childclinic.service.DoctorService;
import com.spring.childclinic.service.ParentService;
import com.spring.childclinic.service.map.DoctorMapService;
import com.spring.childclinic.service.map.ParentMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final ParentService parentService;
    private final DoctorService doctorService;

    public DataInitializer() {
        parentService = new ParentMapService();
        doctorService = new DoctorMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        Parent parent1 = new Parent();
        parent1.setId(1L);
        parent1.setFirstName("Piotr");
        parent1.setLastName("Polut");

        parentService.save(parent1);

        Parent parent2 = new Parent();
        parent2.setId(2L);
        parent2.setFirstName("Kamil");
        parent2.setLastName("Szmagier");

        parentService.save(parent2);

        Doctor doctor1 = new Doctor();
        doctor1.setId(1L);
        doctor1.setFirstName("Marek");
        doctor1.setLastName("Banach");

        doctorService.save(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setId(2L);
        doctor2.setFirstName("Klaudia");
        doctor2.setLastName("Cierniak");

        doctorService.save(doctor2);

    }
}
