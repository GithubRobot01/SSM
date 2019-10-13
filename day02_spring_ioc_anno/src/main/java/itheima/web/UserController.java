package itheima.web;

import itheima.config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import itheima.service.UserService;

public class UserController {
    public static void main(String[] args) {
        //ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        app.close();
        userService.save();
    }
}