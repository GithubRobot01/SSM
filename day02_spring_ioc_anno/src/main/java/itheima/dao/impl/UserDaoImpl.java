package itheima.dao.impl;

import itheima.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("itheima.itcast.dao...save");
    }
}
