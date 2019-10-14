package myssm.test;

import itcast.domain.User;
import itcast.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void add() throws IOException {
        User user=new User();
        user.setUsername("wqs");
        user.setPassword("654321");
        mapper.addUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void update() throws IOException {
        User user=new User();
        user.setId(2);
        user.setUsername("wzy");
        user.setPassword("654321");
        mapper.updateUser(user);
    }

    @Test
    public void del() throws IOException {
        mapper.delUser(4);
    }

    @Test
    public void findOne() throws IOException {
        User user = mapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void findAll() throws IOException {
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void findUserAndOrder(){
        List<User> userAndOrder = mapper.findUserAndOrder();
        for (User user : userAndOrder) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserAndRole(){
        List<User> userAndRole = mapper.findUserAndRole();
        for (User user : userAndRole) {
            System.out.println(user);
        }
    }

}
