package com.itheima.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/user2")
public class UserController2 {

    @RequestMapping("/save")
    public String save(){
        System.out.println("save...");
        return "success";
    }

    @RequestMapping("/save1")
    @ResponseBody
    public void save1(){

    }

    @RequestMapping("/save2")
    @ResponseBody
    public void save2(){

    }

    @RequestMapping("/save3")
    @ResponseBody
    public void save3(){

    }

    @RequestMapping("/save4")
    @ResponseBody
    public void save4(){

    }



}
