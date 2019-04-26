package com.lll.frame.api;


import com.lll.frame.dao.DO.User;
import com.lll.frame.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User
 * 用户api
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:39
 */
@RestController
@RequestMapping("api")
public class UserApi {

    @Autowired
    private IUserService userService;

    @GetMapping("list")
    public List<User> get(){
        return userService.findAll();
    }

    @GetMapping("one")
    public User get(int id){
        return userService.findOne(id);
    }

    @GetMapping("add")
    public int add(){
        return userService.add();
    }

}
