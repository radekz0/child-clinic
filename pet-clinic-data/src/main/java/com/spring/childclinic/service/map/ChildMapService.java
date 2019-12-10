package com.spring.childclinic.service.map;

import com.spring.childclinic.model.Child;
import com.spring.childclinic.service.ChildService;

import java.util.Set;

public class ChildMapService extends AbstractMapService<Child, Long> implements ChildService{
    @Override
    public Set<Child> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public void delete(Child object) {
        super.delete(object);
    }

    @Override
    public Child save(Child object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Child findById(Long id) {
        return super.findById(id);
    }
}
