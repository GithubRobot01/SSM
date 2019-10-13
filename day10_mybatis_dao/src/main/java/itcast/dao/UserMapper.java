package itcast.dao;

import itcast.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    List<User> findAll() throws IOException;
    User findById(int id);
    //条件查询
    List<User> findByCondition(User user);
    List<User> findByIds(List<Integer> ids);

    void save(User user);
}
