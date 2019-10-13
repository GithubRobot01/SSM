package itcast.dao.impl;

import itcast.dao.UserDao;
import itcast.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<User> findAllUser() {
        String sql="select * from sys_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    public Long saveUser(final User user) {

        final String sql="insert into sys_user values(?,?,?,?,?)";
        /*
        jdbcTemplate.update(sql,null,user.getUsername(),user.getEmail(),
        user.getPassword(),user.getPhoneNum());*/

        //创建PreparedStatementCreator
        PreparedStatementCreator creator=new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成一个PreparedStatement的组建
                PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setObject(1,null);
                statement.setString(2,user.getUsername());
                statement.setString(3,user.getEmail());
                statement.setString(4,user.getPassword());
                statement.setString(5,user.getPhoneNum());
                return statement;
            }
        };
        //创建keyHolder
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
        //获得生成的主键
        long userId = keyHolder.getKey().longValue();
        return userId;//该id是数据库自动生成的
    }

    public void saveUserRole(Long id, Long[] roleIds) {
        String sql="insert into sys_user_role values(?,?)";
        if (roleIds!=null){
            for (Long roleId : roleIds) {
                jdbcTemplate.update(sql,id,roleId);
            }
        }
    }

    public void delUserRole(Long userId) {
        String sql="delete from sys_user_role where userId=?";
        jdbcTemplate.update(sql,userId);
    }

    public void delUser(Long userId) {
        String sql="delete from sys_user where id=?";
        jdbcTemplate.update(sql,userId);
    }

    public User login(String username, String password) {
        User user=null;
        try {
            String sql="select * from sys_user where username=? and password=?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (DataAccessException e) {
            //e.printStackTrace();
        }
        return user;
    }
}
