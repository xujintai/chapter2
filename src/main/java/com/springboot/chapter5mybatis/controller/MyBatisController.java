package com.springboot.chapter5mybatis.controller;

import com.springboot.chapter5mybatis.pojo.User;
import com.springboot.chapter5mybatis.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 2018/9/16
 * 创建人 xjt
 */
@Controller
@RequestMapping("/mybatis")
public class MyBatisController {

    @Autowired
    private MyBatisUserService myBatisUserService = null;

    //   http://localhost:8080/mybatis/getUser?id=2
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        return myBatisUserService.getUser(id);
    }
}
