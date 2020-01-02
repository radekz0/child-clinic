package com.spring.childclinic.bootstrap;

import com.spring.childclinic.model.Child;
import com.spring.childclinic.model.Doctor;
import com.spring.childclinic.model.Parent;
import com.spring.childclinic.model.Speciality;
import com.spring.childclinic.model.security.User;
import com.spring.childclinic.service.ChildService;
import com.spring.childclinic.service.DoctorService;
import com.spring.childclinic.service.ParentService;
import com.spring.childclinic.service.SpecialityService;
import com.spring.childclinic.service.security.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ParentService parentService;
    private final DoctorService doctorService;
    private final ChildService childService;
    private final SpecialityService specialityService;
    private final UserService userService;

    public DataInitializer(ParentService parentService, DoctorService doctorService, ChildService childService, SpecialityService specialityService, UserService userService) {
        this.parentService = parentService;
        this.doctorService = doctorService;
        this.childService = childService;
        this.specialityService = specialityService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();
    }

    private void loadData() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.save(user);

        Parent parent1 = new Parent();
        parent1.setFirstName("Artur");
        parent1.setLastName("Zielinski");
        parentService.save(parent1);

        Parent parent2 = new Parent();
        parent2.setFirstName("Kamil");
        parent2.setLastName("Szmagier");
        parentService.save(parent2);

        Child child1 = new Child(parent1, LocalDate.now());
        child1.setFirstName("Natalia");
        child1.setLastName("Zielinska");
        childService.save(child1);

        Child child2 = new Child(parent2, LocalDate.now());
        child1.setFirstName("Anna");
        child1.setLastName("Szmagier");
        childService.save(child2);

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Radiology");
        Speciality savedSpeciality1 = specialityService.save(speciality1);

        Speciality speciality2 = new Speciality();
        speciality1.setDescription("Surgery");
        Speciality savedSpeciality2 = specialityService.save(speciality2);

        Speciality speciality3 = new Speciality();
        speciality1.setDescription("Dentistry");
        Speciality savedSpeciality3 = specialityService.save(speciality3);


        Doctor doctor1 = new Doctor();
        doctor1.setFirstName("Marek");
        doctor1.setLastName("Banach");
        doctor1.getSpecialities().add(speciality1);
        doctorService.save(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setFirstName("Klaudia");
        doctor2.setLastName("Cierniak");
        doctor1.getSpecialities().add(speciality2);
        doctorService.save(doctor2);
    }
}