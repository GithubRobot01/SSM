package itheima.service.impl;

import itheima.dao.USerDao;
import itheima.service.UserService;

public class UserServiceImpl implements UserService {

    private USerDao userDao;
    /*
    使用set方法依赖注入
    public void setUserDao(USerDao userDao) {
        this.userDao = userDao;
    }*/
    public UserServiceImpl(){

    }

    //使用构造方法注入依赖(构造器注入)
    public UserServiceImpl(USerDao userDao){
        this.userDao=userDao;
    }

    public void save() {
        //调用dao
        /*ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        USerDao userDao = (USerDao) app.getBean("userDao");
        */
        userDao.save();
    }
}
