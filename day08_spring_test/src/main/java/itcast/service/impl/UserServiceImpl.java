package itcast.service.impl;

import itcast.dao.RoleDao;
import itcast.dao.UserDao;
import itcast.domain.Role;
import itcast.domain.User;
import itcast.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> list() {
        List<User> userList = userDao.findAllUser();
        for (User user : userList) {
            Long id = user.getId();
            //将id作为参数 查询当前userId对应的Role集合数据
            List<Role> roles=roleDao.findRoleById(id);
            user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        //向sys_user表中存储数据
        Long userId = userDao.saveUser(user);
        //向sys_user_role关系表中存储多条数据
        userDao.saveUserRole(userId,roleIds);

    }

    public void del(Long userId) {
        //删除sys_user_role表数据
        userDao.delUserRole(userId);
        //删除sys_user表中数据
        userDao.delUser(userId);
    }

    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
