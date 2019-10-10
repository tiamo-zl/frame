package com.lll.frame.api;

import com.lll.frame.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RedisTest
 * Redis 测试api
 * @Author zl
 * @Create 2019-04-02 14:08
 **/
@RestController
@RequestMapping("api")
public class RedisTest {

  @Autowired
  private IRedisService redisService;

  /**
   * 添加
   * @return
   */
  @GetMapping(value="/redisAdd")
  public boolean saveRedis(){
    return redisService.setNx("zl", "lll", 100);
  }

  /**
   * 获取
   * @return
   */
  @GetMapping(value="/redisGet")
  public String getRedis(){
    return (String)redisService.get("zl");
  }

}
