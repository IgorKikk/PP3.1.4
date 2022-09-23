package com.example.PP314.dao;

import com.example.PP314.model.Role;

import java.util.List;

public interface RoleDao {

    void createRole(Role role);

    List<Role> getAllRoles();

    Role finedRoleByRoleName(String roleName);

    Role finedRoleById(long id);

}
