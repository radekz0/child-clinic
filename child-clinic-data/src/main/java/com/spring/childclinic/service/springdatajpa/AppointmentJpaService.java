package com.spring.childclinic.service.springdatajpa;

import com.spring.childclinic.model.Appointment;
import com.spring.childclinic.repository.AppointmentRepository;
import com.spring.childclinic.service.AppointmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JpaService")
public class AppointmentJpaService implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentJpaService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Set<Appointment> findAll() {
        Set<Appointment> appointments = new HashSet<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    @Override
    public Appointment findById(Long aLong) {
        return appointmentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Appointment save(Appointment object) {
        return appointmentRepository.save(object);
    }

    @Override
    public void delete(Appointment object) {
        appointmentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        appointmentRepository.deleteById(aLong);
    }
}
