package com.example.spring_security.service;

import com.example.spring_security.dao.RoleDao;
import com.example.spring_security.dao.UserDao;
import com.example.spring_security.entity.Role;
import com.example.spring_security.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * @created 05/07/2023 - 1:56 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserDao userDao;
    private final RoleDao roleDao;
    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public User addUser(User user) {
        String pass = user.getPassword();
        String hashPass = passwordEncoder.encode(pass);
        user.setPassword(hashPass);
        return userDao.addUser(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public void attachRoleToUser(String userName, String roleName) {
        Role r = roleDao.findRoleByName(roleName);
        User u = userDao.findByUserName(userName);
        u.addRole(r);
        userDao.updateUser(u);
    }

    @Override
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public Optional<User> selectUserById(Long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public Optional<User> deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));


    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}
