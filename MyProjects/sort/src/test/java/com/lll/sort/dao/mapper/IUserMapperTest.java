package com.lll.sort.dao.mapper;

import com.lll.sort.SortApplicationTests;
import com.lll.sort.dao.DO.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IUserMapperTest extends SortApplicationTests {

    @Autowired
    IUserMapper userMapper;

    @Test
    public void findAllTest(){
        List<User> all = userMapper.findAll();
        Assert.assertEquals(all.size(), 5);
    }
}