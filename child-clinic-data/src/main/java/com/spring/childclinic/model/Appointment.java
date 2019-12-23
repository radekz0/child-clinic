package com.spring.childclinic.model;

import java.time.LocalDate;

public class Appointment extends BaseEntity{

    private LocalDate date;
    private String description;
    private Child child;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}