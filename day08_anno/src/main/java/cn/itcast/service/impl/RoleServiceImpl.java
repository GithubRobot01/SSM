package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}
