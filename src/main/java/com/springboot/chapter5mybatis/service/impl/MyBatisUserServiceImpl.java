package com.springboot.chapter5mybatis.service.impl;

import com.springboot.chapter5mybatis.dao.MyBatisUserDao;
import com.springboot.chapter5mybatis.pojo.User;
import com.springboot.chapter5mybatis.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2018/9/16
 * 创建人 xjt
 */
@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao = null;

    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
