package itcast.dao;

import itcast.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findRoleList();

    void addRole(Role role);

    List<Role> findRoleById(Long id);
}
