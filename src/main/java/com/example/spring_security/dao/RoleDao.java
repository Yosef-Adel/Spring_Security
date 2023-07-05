package com.example.spring_security.dao;

import com.example.spring_security.entity.Role;

/*
 * @created 05/07/2023 - 1:27 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
public interface RoleDao {
    public Role findRoleByName(String theRoleName);

    public Role addRole(Role role);

    public void deleteRole(Long id);
}
