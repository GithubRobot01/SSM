package Test;

import itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testUpdate(){
        int count = jdbcTemplate.update("update account set money = ? where name =?", 100000000,"lisi");
        System.out.println(count);
    }
    @Test
    public void testDelete(){
        int count = jdbcTemplate.update("delete from  account where name =?", "万强胜");
        System.out.println(count);
    }
    @Test
    public void testQueryAll(){
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(list);
    }
    @Test
    public void testQuery(){
        Account account = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class),"wqs");
        System.out.println(account);
    }
}
