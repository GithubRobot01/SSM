package cn.itcast.dao.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Role> findAll() {
        String sql="select * from sys_role";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void addRole(Role role) {
        String sql="insert into sys_role values(?,?,?)";
        jdbcTemplate.update(sql,null,role.getRoleName(),role.getRoleDesc());
    }
}
