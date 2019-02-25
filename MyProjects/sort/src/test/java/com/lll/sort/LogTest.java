package com.lll.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: LogTest
 * @Description: 日志测试
 * @Author: zl
 * @Create: 2019-02-25 22:44
 **/
@Slf4j
public class LogTest extends SortApplicationTests{

  @Test
  public void  logtest(){
    log.info("----------->");
    log.info("----------->");
    log.info("----------->");
    log.info("----------->");
    log.info("----------->");
    log.info("----------->");
    log.info("----------->");
    log.info("----------->");
    log.info("----------->");
  }
}

