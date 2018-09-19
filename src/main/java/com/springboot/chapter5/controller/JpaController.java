package com.springboot.chapter5.controller;

import com.springboot.chapter5.dao.JpaUserRepository;
import com.springboot.chapter5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *这里 @RestController  ==  @Controller + @ResponseBody
 *
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private JpaUserRepository jpaUserRepository = null;

    //  http://localhost:8090/jpa/getUser?id=1
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        //使用JPA接口查询对象
        User user = jpaUserRepository.findById(id).get();
        return user;
    }

    //自己写的SQL语句
    //http://localhost:8090/jpa/findUsers?userName=张三&note=爱
    @RequestMapping("/findUsers")
    @ResponseBody
    public List<User> findUsers(String userName, String note){
        List<User> list = jpaUserRepository.findUsers(userName,note);
        return  list;
    }

    //  http://localhost:8081/jpa/findByUserNameLike?userName=%E5%BC%A0%E4%B8%89
    @RequestMapping("/findByUserNameLike")
    @ResponseBody
    List<User> findByUserNameLike(String userName){
        //使用JPA接口查询对象
        List<User> list = jpaUserRepository.findByUserNameLike("%"+userName+"%");
        return list;
    }

    //  http://localhost:8081/jpa/getUserById?id=2
    @RequestMapping("/getUserById")
    @ResponseBody
    User getUserById(Long id){
        //使用JPA接口查询对象
        User user = jpaUserRepository.getUserById(id);
        return user;
    }

    //  http://localhost:8081/jpa/findByUserNameLikeOrNoteLike?userName=%E5%BC%A0&note=%E7%88%B1
    @RequestMapping("/findByUserNameLikeOrNoteLike")
    @ResponseBody
    List<User> findByUserNameLikeOrNoteLike(String userName,String note){
        String userNameLike = "%" + userName + "%";
        String noteLike = "%" + note + "%";
        //使用JPA接口查询对象
        List<User> list = jpaUserRepository.findByUserNameLikeOrNoteLike(userNameLike,noteLike);
        return list;
    }

}
