package itheima.service.impl;

import itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import itheima.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {
    /*@Autowired
    @Qualifier("userDao")*/
    @Resource(name = "userDao")
    private UserDao userDao;

    @PostConstruct
    public void init(){
        System.out.println("初始化...");
    }
    public void save() {
        userDao.save();
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁...");
    }
}
