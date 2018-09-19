package com.springboot.chapter5mybatis.dao;

import com.springboot.chapter5mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //获取单个用户
    public User getUser(Long id);
    //查询用户，指定MyBatis的参数名称
    public List<User> findUsers(@Param("userName") String userName,
                                @Param("note") String note);
    //保存用户
    int insertUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(User user);
}
