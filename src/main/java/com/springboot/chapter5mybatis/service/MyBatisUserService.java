package com.springboot.chapter5mybatis.service;

import com.springboot.chapter5mybatis.pojo.User;

public interface MyBatisUserService {
    public User getUser(Long id);
}
