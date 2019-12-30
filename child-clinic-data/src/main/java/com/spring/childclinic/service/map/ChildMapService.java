package com.spring.childclinic.service.map;

import com.spring.childclinic.model.Child;
import com.spring.childclinic.service.ChildService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
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
        return super.save(object);
    }

    @Override
    public Child findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Child findByLastName(String lastName) {
        return null;
    }
}
