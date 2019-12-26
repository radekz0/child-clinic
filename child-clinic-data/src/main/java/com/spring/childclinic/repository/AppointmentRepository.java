package com.spring.childclinic.repository;

import com.spring.childclinic.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
