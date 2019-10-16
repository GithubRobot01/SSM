package itheima.dao.impl;

import itheima.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("userDao")
@Repository("userDao")
//使用@Compont或@Repository标识UserDaoImpl需要Spring进行实例化
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("dao...save");
    }
}
