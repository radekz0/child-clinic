package com.spring.childclinic.service.security;

import com.spring.childclinic.model.security.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}