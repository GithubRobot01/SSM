package myssm.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import itcast.dao.UserMapper;
import itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {
    @Test
    public void test1() throws IOException {
        InputStream is= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件查询
        User condition =new User();
        condition.setUsername("wzy");
        condition.setPassword("123");
        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);
    }

    @Test
    public void test2() throws IOException {
        InputStream is= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(7);
        List<User> users = mapper.findByIds(list);
        System.out.println(users);
    }


    @Test
    public void test3() throws IOException {
        InputStream is= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("wqs");
        user.setPassword("123456");
        user.setBirthday(new Date());
        mapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //分页
    public void test4() throws IOException {
        InputStream is= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(2,5);
        List<User> useList = mapper.findAll();
        for (User user : useList) {
            System.out.println(user);
        }

        //获取分页相关参数
        PageInfo<User> pageInfo=new PageInfo<User>(useList);
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());

        sqlSession.close();
    }
}
