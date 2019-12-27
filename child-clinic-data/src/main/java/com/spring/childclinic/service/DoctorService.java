package com.spring.childclinic.service;

import com.spring.childclinic.model.Doctor;
import com.spring.childclinic.model.Parent;

public interface DoctorService extends CrudService<Doctor, Long>{
    Doctor findByLastName(String lastName);
}
