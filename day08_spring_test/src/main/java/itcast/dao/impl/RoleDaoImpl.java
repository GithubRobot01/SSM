package itcast.dao.impl;

import itcast.dao.RoleDao;
import itcast.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Role> findRoleList() {
        String sql="select * from sys_role";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void addRole(Role role) {
        String sql="insert into sys_role value(?,?,?)";
        jdbcTemplate.update(sql,null,role.getRoleName(),role.getRoleDesc());
    }

    public List<Role> findRoleById(Long id) {
        String sql="select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId = ?";
        List<Role> roles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class),id);
        return roles;
    }
}
