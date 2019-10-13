package itcast.service;

import itcast.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> list();

    void addRole(Role role);
}
