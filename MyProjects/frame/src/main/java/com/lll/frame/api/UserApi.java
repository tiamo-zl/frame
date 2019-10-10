package com.lll.frame.api;


import com.lll.frame.dao.DO.User;
import com.lll.frame.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User
 * 用户api
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:39
 */
@RestController
@RequestMapping("api/user")
public class UserApi {

    @Autowired
    private IUserService userService;

    /**
     * 获取所有人员
     * @return
     */
    @GetMapping("list")
    public List<User> list(){
        List<User> list = new ArrayList<>();
        list.add(new User(1,"zl", 18));
        list.add(new User(2,"cc", 18));
        return list;
    }

    /**
     * 根据人员id获取人员
     * @return
     */
    @GetMapping("get")
    public User get(){
        System.out.println(1/0);
        return null;
//        return userService.findOne(id);
    }


    /**
     * post
     * @return
     */
    @PostMapping("add")
    public User add(
            String appId,
            String name,
            @RequestBody List<User> list){

        System.out.println(appId + " : " + name);
        for (User user : list) {
            System.out.println(user);
        }
        User user = new User();
        user.setId(111);
        return user;
    }

    /**
     * post
     * @return
     */
    @PostMapping("delete")
    public String delete(
            @RequestBody User user){
        return "azl";
    }


}
