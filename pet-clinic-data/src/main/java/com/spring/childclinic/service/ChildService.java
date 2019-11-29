package com.spring.childclinic.service;

import com.spring.childclinic.model.Child;

import java.util.Set;

public interface ChildService {

    Child findById(Long id);

    Child save(Child child);

    Set<Child> findAll();

}
