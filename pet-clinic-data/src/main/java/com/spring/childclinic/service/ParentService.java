package com.spring.childclinic.service;

import com.spring.childclinic.model.Parent;

import java.util.Set;

public interface ParentService {

    Parent findByLastName(String lastName);

    Parent findById(Long Id);

    Parent save(Parent parent);

    Set<Parent> findAll();

}
