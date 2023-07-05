package com.example.spring_security.service;

import com.example.spring_security.entity.Role;
import com.example.spring_security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

/*
 * @created 05/07/2023 - 1:53 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    User addUser(User user);
    Role addRole(Role role);
    void attachRoleToUser(String userName, String roleName);
    List<User> selectAllUsers();
    Optional<User> selectUserById(Long id);
    Optional<User> deleteUser(Long id);
    User updateUser( User user);

}
