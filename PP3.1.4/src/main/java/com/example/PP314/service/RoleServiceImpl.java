package com.example.PP314.service;

import com.example.PP314.dao.RoleDao;
import com.example.PP314.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void createRole(Role role) {
        roleDao.createRole(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role finedRoleByRoleName(String roleName) {
       return roleDao.finedRoleByRoleName(roleName);
    }

    @Override
    public Role finedRoleById(long id) {
        return roleDao.finedRoleById(id);
    }


}
