package com.lll.sort.dao.DO;

import lombok.Data;

/**
 * @ClassName User
 * @Description 用户数据操作
 * @Author zl
 * @Create 2019-04-11 11:13
 **/
@Data
public class User {
    /**
     * id
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 邮箱
     */
    private String email;
}
