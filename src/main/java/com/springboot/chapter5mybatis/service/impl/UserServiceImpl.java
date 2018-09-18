package com.springboot.chapter5mybatis.service.impl;

import com.springboot.chapter5mybatis.dao.UserDao;
import com.springboot.chapter5mybatis.pojo.User;
import com.springboot.chapter5mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        return userDao.findUsers(userName,note);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }
}
