package com.spring.childclinic.model;

import java.util.Set;

public class Doctor extends Person {
    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    private Set<Speciality> specialities;
}
