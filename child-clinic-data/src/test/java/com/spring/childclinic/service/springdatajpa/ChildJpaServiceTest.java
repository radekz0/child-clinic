package com.spring.childclinic.service.springdatajpa;

import com.spring.childclinic.model.Child;
import com.spring.childclinic.model.Parent;
import com.spring.childclinic.repository.ChildRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChildJpaServiceTest {

    public static final String LAST_NAME = "testName";

    Child returnChild;
    Parent parent;

    @Mock
    ChildRepository childRepository;

    @InjectMocks
    ChildJpaService childJpaService;

    @BeforeEach
    void setUp() {
        returnChild = new Child(parent, LocalDate.now());
        returnChild.setId(1L);
        returnChild.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(childRepository.findByLastName(any())).thenReturn(returnChild);
        Child child1 = childJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, child1.getLastName());
    }

    @Test
    void findAll() {
        Set<Child> returnChildSet = new HashSet<>();
        Child child1 = new Child(parent, LocalDate.now());
        Child child2 = new Child(parent, LocalDate.now());
        child1.setId(1L);
        child1.setId(2L);
        returnChildSet.add(child1);
        returnChildSet.add(child2);

        when(childRepository.findAll()).thenReturn(returnChildSet);

        Set<Child> childSet = childJpaService.findAll();

        assertEquals(2, childSet.size());
    }

    @Test
    void findById() {
        when(childRepository.findById(anyLong())).thenReturn(Optional.of(returnChild));
        Child child1 = childJpaService.findById(1L);

        assertNotNull(child1);
    }

    @Test
    void save() {
        Child childToSave = new Child(parent, LocalDate.now());

        when(childRepository.save(any())).thenReturn(returnChild);

        childJpaService.save(childToSave);

        assertNotNull(childToSave);
        verify(childRepository).save(any());
    }

    @Test
    void delete() {
        childJpaService.delete(returnChild);

        verify(childRepository).delete(any());
    }

    @Test
    void deleteById() {
        childJpaService.deleteById(1L);

        verify(childRepository).deleteById(anyLong());
    }
}