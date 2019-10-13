package itcast;

import itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test1() throws IOException {
        //获取核心配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数:namespace+id
        List<Object> userList = sqlSession.selectList("userMapper.findAll","ergou");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //获取核心配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数:namespace+id
        User user=new User();
        user.setUsername("wzy");
        user.setPassword("123");
        sqlSession.insert("userMapper.addUser",user);
        System.out.println(user.getId());
        //mybatis执行更新操作  提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        //获取核心配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数:namespace+id
        User user=new User();
        user.setId(7);
        user.setUsername("ergou");
        user.setPassword("123");
        sqlSession.update("userMapper.updateUser",user);
        //mybatis执行更新操作  提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        //获取核心配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数:namespace+id
        sqlSession.delete("userMapper.delUser",7);
        //mybatis执行更新操作  提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


}
