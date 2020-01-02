package com.spring.childclinic.repository.security;

import com.spring.childclinic.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
