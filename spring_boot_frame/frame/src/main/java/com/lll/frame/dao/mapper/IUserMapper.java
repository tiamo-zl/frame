package com.lll.frame.dao.mapper;

import com.lll.frame.dao.DO.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * IUserMapper
 *
 * @Author zl
 * @Create 2019-04-11 10:50
 **/
@Mapper
@Repository
public interface IUserMapper {

    /**
     * 新增一个userh
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
