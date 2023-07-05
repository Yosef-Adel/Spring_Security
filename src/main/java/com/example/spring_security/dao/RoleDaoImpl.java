package com.example.spring_security.dao;

import com.example.spring_security.entity.Role;
import com.example.spring_security.repo.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/*
 * @created 05/07/2023 - 1:28 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@Repository
@RequiredArgsConstructor
public class RoleDaoImpl implements  RoleDao{
    private final RoleRepository roleRepository;
    @Override
    public Role findRoleByName(String theRoleName) {
        return roleRepository.findByName(theRoleName);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }


}
