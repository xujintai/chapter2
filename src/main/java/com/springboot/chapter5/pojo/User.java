package com.springboot.chapter5.pojo;

import com.springboot.chapter5.converter.SexConverter;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

//标明是一个实体类
@Entity(name = "user")
//定义映射的表
@Table(name = "t_user")
public class User {
    //标明主键
    @Id
    //主键策略，递增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    //定义属性和表的映射关系
    @Column(name = "user_name")
    private String userName = null;

    //定义转换器
    @Convert(converter = SexConverter.class)
    private SexEnum sex = null;//枚举
    private String note = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
