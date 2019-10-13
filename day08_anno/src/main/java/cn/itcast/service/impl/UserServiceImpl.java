package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    public List<User> findAllUser() {
        List<User> userList = userDao.findAllUser();
        if (userList!=null){
            for (User user : userList) {
                //查找用户角色信息
                List<Role> roles=userDao.findRoleByUid(user.getId());
                user.setRoles(roles);
            }
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        Long userId=userDao.saveUser(user);

        if (roleIds!=null){
            for (Long roleId : roleIds) {
                userDao.saveUserRoleRel(userId,roleId);
            }
        }
    }

    public void delUser(Long id) {
        userDao.delUserRoleRel(id);
        userDao.delUSer(id);
    }

    public User login(User user) {
        return userDao.login(user);
    }
}
