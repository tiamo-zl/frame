package com.lll.frame.dao.mapper;

import com.lll.frame.FrameApplicationTests;
import com.lll.frame.dao.DO.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

public class IUserMapperTest extends FrameApplicationTests {

    @Resource
    IUserMapper userMapper;
    
    @Test
    public void findAllTest(){
        List<User> all = userMapper.findAll();
        Assert.assertEquals(all.size(), 12);
    }

    @Test
    public void findOneTest(){
        User user = userMapper.findById(1);
        Assert.assertEquals(user.getId(), 1);
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setAge(10);
        user.setEmail("1111");
        user.setName("zl");

        userMapper.insert(user);
        Assert.assertEquals(user.getId(), 14);
    }

}