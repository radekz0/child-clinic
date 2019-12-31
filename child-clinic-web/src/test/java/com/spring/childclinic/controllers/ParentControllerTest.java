package com.spring.childclinic.controllers;

import com.spring.childclinic.model.Parent;
import com.spring.childclinic.service.ParentService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ParentControllerTest {

    @Mock
    ParentService parentService;

    @InjectMocks
    ParentController parentController;

    Set<Parent> parents;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        parents = new HashSet<>();
        Parent parent1 = new Parent();
        Parent parent2 = new Parent();
        parents.add(parent1);
        parents.add(parent2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(parentController)
                .build();
    }

    @Test
    void listParents() throws Exception {
        when(parentService.findAll()).thenReturn(parents);

        mockMvc.perform(MockMvcRequestBuilders.get("/parents"))
                .andExpect(status().isOk())
                .andExpect(view().name("parents/index"))
                .andExpect(model().attribute("parents", hasSize(2)));
    }
}