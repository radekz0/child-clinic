package com.spring.childclinic.service.springdatajpa;

import com.spring.childclinic.model.Appointment;
import com.spring.childclinic.model.Parent;
import com.spring.childclinic.repository.AppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppointmentJpaServiceTest {

    public static final String DESCRIPTION = "testDescription";

    Appointment returnAppointment;

    @Mock
    AppointmentRepository appointmentRepository;

    @InjectMocks
    AppointmentJpaService appointmentJpaService;

    @BeforeEach
    void setUp() {
        returnAppointment = new Appointment();
        returnAppointment.setId(1L);
        returnAppointment.setDescription(DESCRIPTION);
    }

    @Test
    void findAll() {
        Set<Appointment> returnAppointmentSet = new HashSet<>();
        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();
        appointment1.setId(1L);
        appointment2.setId(2L);
        returnAppointmentSet.add(appointment1);
        returnAppointmentSet.add(appointment2);

        when(appointmentRepository.findAll()).thenReturn(returnAppointmentSet);

        Set<Appointment> appointmentSet = appointmentJpaService.findAll();

        assertEquals(2, appointmentSet.size());
    }

    @Test
    void findById() {
        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(returnAppointment));
        Appointment appointment1 = appointmentJpaService.findById(1L);

        assertNotNull(appointment1);
    }

    @Test
    void save() {
        Appointment appointmentToSave = new Appointment();

        when(appointmentRepository.save(any())).thenReturn(returnAppointment);

        appointmentJpaService.save(appointmentToSave);

        assertNotNull(appointmentToSave);
        verify(appointmentRepository).save(any());
    }

    @Test
    void delete() {
        appointmentJpaService.delete(returnAppointment);

        verify(appointmentRepository).delete(any());
    }

    @Test
    void deleteById() {
        appointmentJpaService.deleteById(1L);

        verify(appointmentRepository).deleteById(anyLong());
    }
}