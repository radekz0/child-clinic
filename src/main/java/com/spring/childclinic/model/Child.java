package com.spring.childclinic.model;

import java.time.LocalDate;

public class Child extends Person{

    private Parent parent;
    private LocalDate birthDate;

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
