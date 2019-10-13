package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    void save(User user, Long[] roleIds);

    void delUser(Long id);

    User login(User user);
}
