package com.spring.childclinic.repository;

import com.spring.childclinic.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Doctor findByLastName(String lastName);
}
