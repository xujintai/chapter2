package com.springboot.chapter5mybatis.converter;

import com.springboot.chapter5mybatis.pojo.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 自定义字符串转换器
 */
@Component
public class StringToUserConverter implements Converter<String,User> {

    @Override
    public User convert(String userStr) {
        System.out.println(111111111);
        User user = new User();
        String[] strArr = userStr.split("-");
        Long id = Long.parseLong(strArr[0]);
        String userName = strArr[1];
        String note = strArr[2];
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        System.out.println(22222222);
        return user;
    }
}
