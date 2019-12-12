package com.spring.childclinic.service.map;

import com.spring.childclinic.model.Parent;
import com.spring.childclinic.service.CrudService;
import com.spring.childclinic.service.ParentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ParentMapService extends AbstractMapService<Parent, Long> implements ParentService{

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
        return super.save(object);
    }

    @Override
    public Parent findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Parent findByLastName(String lastName) {
        return null;
    }
}