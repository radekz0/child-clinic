package com.spring.childclinic.service.springdatajpa;

import com.spring.childclinic.model.Parent;
import com.spring.childclinic.repository.ParentRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParentJpaServiceTest {

    public static final String LAST_NAME = "Zielinski";

    Parent returnParent;

    @Mock
    ParentRepository parentRepository;

    @InjectMocks
    ParentJpaService parentJpaService;

    @BeforeEach
    void setUp() {
        returnParent = new Parent();
        returnParent.setId(1L);
        returnParent.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(parentRepository.findByLastName(any())).thenReturn(returnParent);
        Parent parent1 = parentJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, parent1.getLastName());
    }

    @Test
    void findAll() {
        Set<Parent> returnParentSet = new HashSet<>();
        Parent parent1 = new Parent();
        Parent parent2 = new Parent();
        parent1.setId(1L);
        parent1.setId(2L);
        returnParentSet.add(parent1);
        returnParentSet.add(parent2);

        when(parentRepository.findAll()).thenReturn(returnParentSet);

        Set<Parent> parentSet = parentJpaService.findAll();

        assertEquals(2, parentSet.size());
    }

    @Test
    void findById() {
        when(parentRepository.findById(anyLong())).thenReturn(Optional.of(returnParent));
        Parent parent1 = parentJpaService.findById(1L);

        assertNotNull(parent1);
    }

    @Test
    void save() {
        Parent parentToSave = new Parent();

        when(parentRepository.save(any())).thenReturn(returnParent);

        parentJpaService.save(parentToSave);

        assertNotNull(parentToSave);
        verify(parentRepository).save(any());
    }

    @Test
    void delete() {
        parentJpaService.delete(returnParent);

        verify(parentRepository).delete(any());
    }

    @Test
    void deleteById() {
        parentJpaService.deleteById(1L);

        verify(parentRepository).deleteById(anyLong());
    }
}