package com.springboot.chapter5mybatis.dao;

import com.springboot.chapter5mybatis.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {
    public User getUser(Long id);
}
