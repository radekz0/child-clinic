package com.spring.childclinic.model;

import java.util.Set;

public class Parent extends Person {
    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    private Set<Child> children;
}
