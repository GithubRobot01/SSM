package Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcTemplateTest {
    @Test
    //测试JdbcTemplate开发步骤
    public void test() throws PropertyVetoException {
        //创建数据源对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //设置数据源
        jdbcTemplate.setDataSource(dataSource);
        String sql="insert into account values(?,?)";
        int count = jdbcTemplate.update(sql, "张三", 999);
        System.out.println(count);
    }

    @Test
    //使用Spring容器产生JdbcTemplate对象
    public void test2(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        String sql="insert into account values(?,?)";
        int count = jdbcTemplate.update(sql, "wqs", 50000000);
        System.out.println(count);

    }
}
