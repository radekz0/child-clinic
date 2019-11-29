package com.spring.childclinic.service;

import com.spring.childclinic.model.Parent;

public interface ParentService extends  CrudService<Parent, Long>{

    Parent findByLastName(String lastName);

}
