package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUser();

    List<Role> findRoleByUid(Long id);

    Long saveUser(User user);

    void saveUserRoleRel(Long id, Long roleId);

    void delUserRoleRel(Long id);

    void delUSer(Long id);

    User login(User user);
}
