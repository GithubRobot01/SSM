package itcast.dao;

import itcast.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUser();

    Long saveUser(User user);

    void saveUserRole(Long id, Long[] roleIds);

    void delUserRole(Long userId);

    void delUser(Long userId);

    User login(String username, String password);
}
