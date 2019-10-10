package com.lll.sort.service;


import com.lll.sort.dao.DO.User;

import java.util.List;

/**
 * @ClassName: IUserService
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:51
 */
public interface IUserService {

    /**
     * 根据id进行查找
     * @param id id
     * @return 用户信息
     */
    User findOne(int id);

    /**
     * 查找所有
     * @return
     */
    List<User> findAll();

    /**
     * 新增
     * @return
     */
    int add();
}
