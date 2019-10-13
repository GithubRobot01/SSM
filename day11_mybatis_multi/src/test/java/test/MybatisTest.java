package test;

import itcast.domain.Order;
import itcast.domain.User;
import itcast.mapper.OrderMapper;
import itcast.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    //查询所有订单及下单人信息
    public void test1() throws IOException {
        InputStream is= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.findAll();

        for (Order order : orderList) {
            System.out.println(order);
        }

        sqlSession.close();
    }

    @Test
    //查询所有用户的订单信息
    public void test2() throws IOException {
        InputStream is= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    //查询所有用户的角色信息
    public void test3() throws IOException {
        InputStream is= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userAndRole = mapper.findUserAndRole();
        for (User user : userAndRole) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
