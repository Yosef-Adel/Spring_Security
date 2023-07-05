package com.example.spring_security.repo;

import com.example.spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @created 05/07/2023 - 1:20 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    boolean existsUserByUserName(String userName);
}
