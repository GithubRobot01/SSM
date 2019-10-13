package itcast.mapper;

import itcast.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    List<User> findUserAndRole();
}
