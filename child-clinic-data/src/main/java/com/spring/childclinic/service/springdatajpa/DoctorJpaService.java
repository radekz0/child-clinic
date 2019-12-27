package com.spring.childclinic.service.springdatajpa;

import com.spring.childclinic.model.Doctor;
import com.spring.childclinic.repository.DoctorRepository;
import com.spring.childclinic.service.DoctorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("JpaService")
public class DoctorJpaService implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorJpaService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findByLastName(String lastName) {
        return doctorRepository.findByLastName(lastName);
    }

    @Override
    public Set<Doctor> findAll() {
        Set<Doctor> doctors = new HashSet<>();
        doctorRepository.findAll().forEach(doctors::add);
        return doctors;
    }

    @Override
    public Doctor findById(Long aLong) {
        Optional<Doctor> doctors = doctorRepository.findById(aLong);
        return doctors.orElse(null);
    }

    @Override
    public Doctor save(Doctor object) {
        return doctorRepository.save(object);
    }

    @Override
    public void delete(Doctor object) {
        doctorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        doctorRepository.deleteById(aLong);
    }
}
