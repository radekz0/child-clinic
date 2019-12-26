package com.spring.childclinic.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "children")
public class Child extends Person{

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "child")
    private Set<Appointment> appointmentSet = new HashSet<>();

    public Child(Parent parent, LocalDate birthDate) {
        this.parent = parent;
        this.birthDate = birthDate;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}