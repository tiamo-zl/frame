package com.lll.sort.service;


import com.lll.sort.service.enter.UserVO;

/**
 * @ClassName: IUserService
 * @Description:
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:51
 */
public interface IUserService {

    /**
     * 根据id进行查找
     * @param id
     * @return
     */
    UserVO findOne(int id);
}
