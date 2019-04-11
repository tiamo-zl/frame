package com.lll.sort.dao.mapper;

import com.lll.sort.dao.DO.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName IUserMapper
 * @Description
 * @Author zl
 * @Create 2019-04-11 10:50
 **/
@Mapper
public interface IUserMapper {

    /**
     * 新增一个user
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 通过id进行查找
     * @param id
     * @return
     */
    User findById(@Param("id") int id);

    /**
     * 查找所有的用户
     * @return
     */
    List<User> findAll();

}
