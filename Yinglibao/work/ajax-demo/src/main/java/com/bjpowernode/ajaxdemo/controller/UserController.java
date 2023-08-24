package com.bjpowernode.ajaxdemo.controller;

import com.bjpowernode.ajaxdemo.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaogao
 * @version 1.0
 * @className UserController
 * @description
 * @since 1.0
 */
// 当前的controller支持跨域
@CrossOrigin
@RestController
public class UserController {

    /*get请求*/
    @GetMapping("/user/query")
    public User queryUser(){
        System.out.println("=======/user/query  接收前端的请求===========");
        User user = new User(1001, "张强", 20, "男");
        return user;
    }

    /*两个参数*/
    @GetMapping("/user/get")
    public User queryUser2(Integer id, String name){
        System.out.println("=======/user/get  接收前端的请求===========id=" + id + ", name=" + name);
        User user = new User(id, name, 20, "男");
        return user;
    }

    /*post请求*/
    @PostMapping("/user/add")
    public User addUser(Integer id, String name){
        System.out.println("=======/user/get  接收前端的请求===========id=" + id + ", name=" + name);
        User user = new User(id, name, 20, "男");
        return user;
    }

    /*
    * 前端是json格式的数据，例如{id: 1001, name: "lisi"}
    * 后端控制器方法，使用java对象接收参数，加入@RequestBody
    *
    * @RequestBody: 从请求体中，获取数据，转为形参的对象
    *
    * {"id":1001,"name":"张向","age":20,"sex":"女"}
    *
    * 使用@RequestBody的要求
    * 1.请求头，Content-Type：application/json
    * 2.发起的请求是post，请求数据是json格式
    * 3.服务器接收json转为对象，需要在对象类型的形参前面加入@RequestBody
    * */
    @PostMapping("/user/json")
    public User addUserJson(@RequestBody User user){
        System.out.println("=======/user/json  接收前端的请求======" + user);
        User user1 = new User(1001, "lisi", 20, "男");
        return user;
    }
}
