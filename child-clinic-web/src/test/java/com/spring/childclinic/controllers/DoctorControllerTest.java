package com.spring.childclinic.controllers;

import com.spring.childclinic.model.Doctor;
import com.spring.childclinic.service.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {

    @Mock
    DoctorService doctorService;

    @InjectMocks
    DoctorController doctorController;

    Set<Doctor> doctors;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        doctors = new HashSet<>();
        Doctor doctor1 = new Doctor();
        Doctor doctor2 = new Doctor();

        doctors.add(doctor1);
        doctors.add(doctor2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(doctorController)
                .build();
    }

    @Test
    void listDoctors() throws Exception {
        when(doctorService.findAll()).thenReturn(doctors);

        mockMvc.perform(MockMvcRequestBuilders.get("/doctors"))
                .andExpect(status().isOk())
                .andExpect(view().name("doctors/index"))
                .andExpect(model().attribute("doctors", hasSize(2)));
    }
}