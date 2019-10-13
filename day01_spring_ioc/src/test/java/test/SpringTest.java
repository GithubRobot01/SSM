package test;

import itheima.dao.USerDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    //测试scope属性
    public void test1(){
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        USerDao userDao1 = (USerDao) app.getBean("userDao");
        System.out.println(userDao1);
        //app.close();
    }
}
