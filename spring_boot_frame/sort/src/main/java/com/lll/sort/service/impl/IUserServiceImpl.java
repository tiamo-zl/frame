package com.lll.sort.service.impl;

import com.lll.sort.dao.DO.User;
import com.lll.sort.dao.mapper.IUserMapper;
import com.lll.sort.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: IUserServiceImpl
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:59
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Resource
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
