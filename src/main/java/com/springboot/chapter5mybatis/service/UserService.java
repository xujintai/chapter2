package com.springboot.chapter5mybatis.service;

import com.springboot.chapter5mybatis.pojo.User;

import java.util.List;

public interface UserService {
     //获取单个用户
     User getUser(Long id);
     //查询用户
     List<User> findUsers(String userName, String note);
     //保存用户
     int insertUser(User user);
     //修改用户
     int updateUser(User user);
     //删除用户
     int deleteUser(User user);
}
