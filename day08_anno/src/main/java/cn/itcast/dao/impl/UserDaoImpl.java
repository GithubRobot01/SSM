package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<User> findAllUser() {
        String sql="select * from sys_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    public List<Role> findRoleByUid(Long id) {
        String sql="select * from sys_user_role ur,sys_role r where r.id=ur.RoleId and ur.userId=?";
        List<Role> roles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class),id);
        return roles;
    }

    public Long saveUser(final User user) {
        final String sql="insert into sys_user values(?,?,?,?,?)";
        PreparedStatementCreator creator=new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setObject(2,user.getUsername());
                preparedStatement.setObject(3,user.getEmail());
                preparedStatement.setObject(4,user.getPassword());
                preparedStatement.setObject(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
        Long key = keyHolder.getKey().longValue();
        return key;
    }

    public void saveUserRoleRel(Long id, Long roleId) {
        String sql="insert into sys_user_role values(?,?)";
        jdbcTemplate.update(sql,id,roleId);
    }

    public void delUserRoleRel(Long id) {
        String sql="delete from sys_user_role where userId=?";
        jdbcTemplate.update(sql,id);
    }

    public void delUSer(Long id) {
        String sql="delete from sys_user where id=?";
        jdbcTemplate.update(sql,id);
    }

    public User login(User user) {
        User loginUser=null;
        try {
            String sql="select * from sys_user where username =? and password=?";
            loginUser = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user.getUsername(),user.getPassword());
        } catch (DataAccessException e) {
            //e.printStackTrace();
        }
        return loginUser;
    }
}
