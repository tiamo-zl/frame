package com.lll.frame.service.impl;

import com.lll.frame.dao.DO.User;
import com.lll.frame.dao.mapper.IUserMapper;
import com.lll.frame.service.IRedisService;
import com.lll.frame.service.IUserService;
import com.lll.frame.utils.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IUserServiceImpl
 *
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:59
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    IUserMapper userDao;

    @Autowired
    IRedisService redisService;

    @Override
    public User findOne(int id) {
        User user;
        String key = RedisKey.USER_ID_KEY + id;
        Object value = redisService.get(key);
        if (null == value){
            user = userDao.findById(id);
            redisService.set(key, user, RedisKey.getKeyTime());
        }else{
            user = (User) value;
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users;
        String key = RedisKey.USER_ALL_KEY;
        Object value = redisService.get(key);
        if (null == value){
            users = userDao.findAll();;
            redisService.set(key, users, RedisKey.getKeyTime());
        }else{
            users = (List<User>) value;
        }
        return users;
    }

    @Override
    public int add() {
        User user = new User();
        user.setAge(20);
        user.setEmail("lll6620@163.com");
        user.setName("zl");
        userDao.insert(user);
        /**
         * 删除all
         */
        redisService.del(RedisKey.USER_ALL_KEY);
        return user.getId();
    }
}
