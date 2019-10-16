package test;

import itheima.config.SpringConfiguration;
import itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class) //替换原来的运行期
//使用@ContextConfiguration指定配置文件或配置类
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {

    //注入需要测试的对象
    @Autowired
    private UserService userService;


    @Test
    public void test() throws SQLException {
        System.out.println(userService);
    }

}
