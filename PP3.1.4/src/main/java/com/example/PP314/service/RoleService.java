package com.example.PP314.service;

import com.example.PP314.model.Role;

import java.util.List;

public interface RoleService {

    void createRole(Role role);

    List<Role> getAllRoles();

    Role finedRoleByRoleName(String roleName);

    Role finedRoleById(long id);

}
