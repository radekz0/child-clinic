package com.spring.childclinic.service;


import com.spring.childclinic.model.Doctor;

import java.util.Set;

public interface DoctorService {

    Doctor findById(Long id);

    Doctor save(Doctor doctor);

    Set<Doctor> findAll();
}
