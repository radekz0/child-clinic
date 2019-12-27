package com.spring.childclinic.service.springdatajpa;

import com.spring.childclinic.model.Parent;
import com.spring.childclinic.repository.ParentRepository;
import com.spring.childclinic.service.ParentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("JpaService")
public class ParentJpaService implements ParentService {
    private final ParentRepository parentRepository;

    public ParentJpaService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent findByLastName(String lastName) {
        return parentRepository.findByLastName(lastName);
    }

    @Override
    public Set<Parent> findAll() {
        Set<Parent> parents = new HashSet<>();
        parentRepository.findAll().forEach(parents::add);
        return parents;
    }

    @Override
    public Parent findById(Long aLong) {
        Optional<Parent> parentOptional = parentRepository.findById(aLong);
        return parentOptional.orElse(null);
    }

    @Override
    public Parent save(Parent object) {
        return parentRepository.save(object);
    }

    @Override
    public void delete(Parent object) {
        parentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        parentRepository.deleteById(aLong);
    }
}
