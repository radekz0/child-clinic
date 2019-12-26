package com.spring.childclinic.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parents")
public class Parent extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephonne;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private Set<Child> children;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephonne() {
        return telephonne;
    }

    public void setTelephonne(String telephonne) {
        this.telephonne = telephonne;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }
}