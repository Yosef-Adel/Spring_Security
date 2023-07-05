package com.example.spring_security.dao;

import com.example.spring_security.entity.User;

import java.util.List;
import java.util.Optional;

/*
 * @created 05/07/2023 - 1:23 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
public interface UserDao {
    User findByUserName(String  userName);

    List<User> selectAllUsers();

    Optional<User> selectUserById(Long id);

    User addUser(User user);

    boolean existsUserByUserName(String email);

    boolean existUserById(Long id);

    Optional<User> deleteUser(Long id);
    User updateUser( User user);

}
