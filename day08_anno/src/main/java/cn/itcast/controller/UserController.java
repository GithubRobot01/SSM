package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.RoleService;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();
        List<User> userList=userService.findAllUser();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/delUser/{userId}")
    public String delUser(@PathVariable("userId") Long id){
        userService.delUser(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(User user,String remember,HttpSession session){
        System.out.println(remember);
        User loginUser=userService.login(user);
        if (loginUser!=null){
            /*if (remember!=null){
                String info=user.getUsername()+"-"+user.getPassword();
                Cookie cookie=new Cookie("userInfo",info);
                cookie.setMaxAge(60*60*5);
            }*/
            session.setAttribute("user",loginUser);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
