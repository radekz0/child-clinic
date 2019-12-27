package com.spring.childclinic.service.springdatajpa;

import com.spring.childclinic.model.Child;
import com.spring.childclinic.repository.ChildRepository;
import com.spring.childclinic.service.ChildService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("JpaService")
public class ChildJpaService implements ChildService {
    private final ChildRepository childRepository;

    public ChildJpaService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public Child findByLastName(String lastName) {
        return childRepository.findByLastName(lastName);
    }

    @Override
    public Set<Child> findAll() {
        Set<Child> children = new HashSet<>();
        childRepository.findAll().forEach(children::add);
        return children;
    }

    @Override
    public Child findById(Long aLong) {
        Optional<Child> child = childRepository.findById(aLong);
        return child.orElse(null);
    }

    @Override
    public Child save(Child object) {
        return childRepository.save(object);
    }

    @Override
    public void delete(Child object) {
        childRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        childRepository.deleteById(aLong);
    }
}