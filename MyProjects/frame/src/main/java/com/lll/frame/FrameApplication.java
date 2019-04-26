package com.lll.frame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * FrameApplication.java
 * 自己搭建的框架启动类
 * @Author: zl
 * @Create: 2019-04-11 17:51
 **/
@SpringBootApplication
@EnableCaching
@MapperScan("com.lll.frame.dao.mapper")
public class FrameApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameApplication.class, args);
    }

}
