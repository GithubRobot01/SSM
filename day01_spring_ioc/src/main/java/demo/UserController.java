package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import itheima.service.UserService;

public class UserController {
    public static void main(String[] args) {
        //调用service
        /*UserService userService=new UserServiceImpl();*/
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        //与容器中的id无法,只获取UserService类型的对象
        //UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
