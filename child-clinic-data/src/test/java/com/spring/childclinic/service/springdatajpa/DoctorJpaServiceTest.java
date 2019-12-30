package com.spring.childclinic.service.springdatajpa;

import com.spring.childclinic.model.Doctor;
import com.spring.childclinic.model.Parent;
import com.spring.childclinic.repository.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DoctorJpaServiceTest {

    public static final String LAST_NAME = "testName";

    Doctor returnDoctor;

    @Mock
    DoctorRepository doctorRepository;

    @InjectMocks
    DoctorJpaService doctorJpaService;

    @BeforeEach
    void setUp() {
        returnDoctor = new Doctor();
        returnDoctor.setId(1L);
        returnDoctor.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(doctorRepository.findByLastName(any())).thenReturn(returnDoctor);
        Doctor parent1 = doctorRepository.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, parent1.getLastName());
    }

    @Test
    void findAll() {
        Set<Doctor> returnDoctorSet = new HashSet<>();
        Doctor doctor1 = new Doctor();
        Doctor doctor2 = new Doctor();
        doctor1.setId(1L);
        doctor2.setId(2L);
        returnDoctorSet.add(doctor1);
        returnDoctorSet.add(doctor2);

        when(doctorRepository.findAll()).thenReturn(returnDoctorSet);

        Set<Doctor> doctorSet = doctorJpaService.findAll();

        assertEquals(2, doctorSet.size());
    }

    @Test
    void findById() {
        when(doctorRepository.findById(anyLong())).thenReturn(Optional.of(returnDoctor));
        Doctor doctor1 = doctorJpaService.findById(1L);

        assertNotNull(doctor1);
    }

    @Test
    void save() {
        Doctor doctorToSave = new Doctor();

        when(doctorRepository.save(any())).thenReturn(returnDoctor);

        doctorJpaService.save(doctorToSave);

        assertNotNull(doctorToSave);
        verify(doctorRepository).save(any());
    }

    @Test
    void delete() {
        doctorJpaService.delete(returnDoctor);

        verify(doctorRepository).delete(any());
    }

    @Test
    void deleteById() {
        doctorJpaService.deleteById(1L);

        verify(doctorRepository).deleteById(anyLong());
    }
}