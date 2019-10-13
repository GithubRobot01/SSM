package itcast.service.impl;

import itcast.dao.RoleDao;
import itcast.domain.Role;
import itcast.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        return roleDao.findRoleList();
    }

    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}
