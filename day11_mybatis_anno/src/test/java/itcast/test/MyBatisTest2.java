package itcast.test;

import itcast.domain.Order;
import itcast.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest2 {

    private OrderMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);
    }


    @Test
    public void findAll() throws IOException {
        List<Order> orderList = mapper.findAll();
        System.out.println(orderList);
    }

}
