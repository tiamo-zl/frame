package com.lll.sort.service.impl;

import com.lll.sort.SortApplicationTests;
import com.lll.sort.service.enter.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserServiceImplTest {

  @Autowired
  private IUserServiceImpl userService;

  @Test
  public void findOne() {
    UserVO user = userService.findOne(1);
    System.out.println(user);
//    Assert.assertEquals(user.getId(), 1);
  }
}
