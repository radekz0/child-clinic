package com.spring.childclinic.service.map;

import com.spring.childclinic.model.Parent;
import com.spring.childclinic.service.CrudService;

import java.util.Set;

public class ParentMapService extends AbstractMapService<Parent, Long> implements CrudService<Parent, Long> {

    @Override
    public Set<Parent> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Parent object) {
        super.delete(object);
    }

    @Override
    public Parent save(Parent object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Parent findById(Long id) {
        return super.findById(id);
    }
}
