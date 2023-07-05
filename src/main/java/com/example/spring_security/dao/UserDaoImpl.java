package com.example.spring_security.dao;

import com.example.spring_security.entity.User;
import com.example.spring_security.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * @created 05/07/2023 - 1:26 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{
    private final UserRepository userRepository ;
    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> selectUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean existsUserByUserName(String email) {
        return userRepository.existsUserByUserName(email);
    }

    @Override
    public boolean existUserById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Optional<User> deleteUser(Long id) {
        Optional<User> byId = userRepository.findById(id);
        userRepository.deleteById(id);
        return byId;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
