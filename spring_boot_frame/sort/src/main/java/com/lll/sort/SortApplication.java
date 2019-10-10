package com.lll.sort;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 入口文件
 * @author zl
 */
@SpringBootApplication()
@EnableCaching
@MapperScan("com.lll.sort.dao.mapper")
public class SortApplication {

    public static void main(String[] args) {

        SpringApplication.run(SortApplication.class, args);
    }

}
