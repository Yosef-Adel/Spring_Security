package com.example.spring_security.repo;

import com.example.spring_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @created 05/07/2023 - 1:28 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
