package com.lll.frame.dao.mapper;

import com.lll.frame.FrameApplicationTests;
import com.lll.frame.dao.DO.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class IUserMapperTest extends FrameApplicationTests{

    @Autowired
    IUserMapper userMapper;

    @Test
    public void findById(){
        User user = userMapper.findById(1);
        Assert.assertNotNull(user);
    }

}