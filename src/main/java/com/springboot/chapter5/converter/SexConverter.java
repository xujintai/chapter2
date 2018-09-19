package com.springboot.chapter5.converter;

import com.springboot.chapter5.pojo.SexEnum;

import javax.persistence.AttributeConverter;

public class SexConverter implements AttributeConverter<SexEnum,Integer> {

    //将枚举转换为数据库列
    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getId();
    }

    //将数据库列转换为枚举
    @Override
    public SexEnum convertToEntityAttribute(Integer integer) {
        return SexEnum.getEnumById(integer);
    }
}
