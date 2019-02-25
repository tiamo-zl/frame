package com.lll.sort.service.impl;

import com.lll.sort.service.IUserService;
import com.lll.sort.service.enter.UserVO;
import org.springframework.stereotype.Service;

/**
 * @ClassName: IUserServiceImpl
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:59
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Override
    public UserVO findOne(int id) {
        UserVO user = new UserVO();
        if (id == 1){
            user.setId(1);
            user.setName("小琛");
        }else {
            user.setId(66666);
            user.setName("小琛琛");
        }
        return user;
    }
}
