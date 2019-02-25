package com.lll.sort.service.impl;

import com.lll.sort.SortApplicationTests;
import com.lll.sort.service.enter.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IUserServiceImplTest extends SortApplicationTests{

    @Autowired
    IUserServiceImpl userServiceImpl;

    @Test
    public void findOne() {
        UserVO user = userServiceImpl.findOne(1);

        Assert.assertEquals(user.getId(), 1);


    }
}