package com.zl.sort.service;

import com.zl.sort.service.enter.UserVO;

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
    public UserVO findOne(int id);
}
