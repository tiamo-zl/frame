package com.lll.frame.service.impl;

import com.lll.frame.dao.DO.User;
import com.lll.frame.dao.mapper.IUserMapper;
import com.lll.frame.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: IUserServiceImpl
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:59
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    IUserMapper userDao;

    @Override
    public User findOne(int id) {

        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int add() {
        User user = new User();
        user.setAge(20);
        user.setEmail("lll6620@163.com");
        user.setName("zl");
        userDao.insert(user);
        return user.getId();
    }
}
