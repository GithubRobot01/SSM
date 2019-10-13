package itheima.dao.impl;

import itheima.dao.USerDao;
import itheima.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements USerDao {
    /*public UserDaoImpl(){
        System.out.println("UserDaoImpl创建");
    }

    public void init(){
        System.out.println("init...");
    }

    public void destory(){
        System.out.println("destory...");
    }*/

    /*普通数据类型注入
    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }*/

    //集合输入
    private List<String> list;
    private Map<String, User> map;
    private Properties properties;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void save() {
        //System.out.println(username+"-"+age);
        System.out.println(list);
        System.out.println(map);
        System.out.println(properties);
        System.out.println("userDao-save...");
    }
}
