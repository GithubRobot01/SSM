package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/quick21")
    @ResponseBody
    public void save21(@CookieValue(value="JSESSIONID",required=false) String jSessionId){
        System.out.println(jSessionId);
    }

    @RequestMapping("/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value="User-Agent",required=false) String agent){
        System.out.println(agent);
    }

    @RequestMapping("/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }


    @RequestMapping("/quick18")
    @ResponseBody
    public void save18(Date date){
        System.out.println(date);
    }

    @RequestMapping("/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable("name") String username){
        System.out.println(username);
    }

    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value="name",required=false,defaultValue="wqs") String username){
        System.out.println(username);
    }

    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(Vo vo){
        System.out.println(vo);
    }

    @RequestMapping("/quick13")
    @ResponseBody
    public void save13(String[] hobby){
        System.out.println(Arrays.asList(hobby));
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user){
        System.out.println(user);
    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick10")
    @ResponseBody
    public User save10(){
        User user=new User();
        user.setUsername("wqs");
        user.setAge(22);
        return user;
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user=new User();
        user.setUsername("wqs");
        user.setAge(22);
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick8")
    @ResponseBody //告诉springMVC框架 不进行视图跳转 直接进行数据响应
    public String save8() {
        return "hello,future!";
    }


    @RequestMapping("/quick7")
    @ResponseBody //告诉springMVC框架 不进行视图跳转 直接进行数据响应
    public String save7() {
        return "hello,future!";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("你好");
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","quick5");
        return "success";
    }

    @RequestMapping("/quick4")
    public String save4(Model model){
        model.addAttribute("username","quick4");
        return "success";
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","wzy");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
        ModelAndView modelAndView=new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","wqs");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("save...");
        return "success";
        //return "redirect:/success.jsp";
    }

}
