package com.spring.childclinic.repository;

import com.spring.childclinic.model.Child;
import org.springframework.data.repository.CrudRepository;

public interface ChildRepository extends CrudRepository<Child, Long> {
}
