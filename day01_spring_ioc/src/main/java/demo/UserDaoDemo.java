package demo;

import itheima.dao.USerDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        USerDao userDao = (USerDao) app.getBean("userDao");
        userDao.save();
    }
}
