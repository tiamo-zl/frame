package com.zl.sort.api;

import com.zl.sort.service.IUserService;
import com.zl.sort.service.enter.UserVO;
import com.zl.sort.service.impl.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: User
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:39
 */
@RestController
@RequestMapping("api")
public class User {

    @Autowired
    private IUserServiceImpl userServiceImpl;

    @GetMapping("user")
    public UserVO get(){
        return userServiceImpl.findOne(1);
    }

}
