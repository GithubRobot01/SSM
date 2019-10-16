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
//使用@Component或@Service标识UserServiceImpl需要Spring进行实例化
public class UserServiceImpl implements UserService {
    /*@Autowired
    @Qualifier("userDao")*/
    @Resource(name = "userDao")
    //使用@Autowired或者@Autowired+@Qulifier或者@Resource进行userDao的注入
    private UserDao userDao;

    @PostConstruct
    //标注初始化方法
    public void init(){
        System.out.println("初始化...");
    }

    public void save() {
        userDao.save();
    }

    @PreDestroy
    //标注销毁方法
    public void destory(){
        System.out.println("销毁...");
    }
}
