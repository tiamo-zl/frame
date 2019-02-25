package com.zl.sort.service.impl;

import com.zl.sort.service.enter.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @ClassName: IUserServiceImplTest
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-25 18:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class IUserServiceImplTest {

    @Autowired
    IUserServiceImpl userService;

    @Test
    public void findOne() {
        UserVO user = userService.findOne(1);
        System.out.println(user);
        System.out.println("--------------------------------------------------");
        Assert.assertEquals(user.getId(),1);
    }
}