package com.springboot.chapter5mybatis.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 第十章
 */
@RequestMapping("/my")
@Controller
public class MyController {

    /**
     * 在无注解下获取参数，要求参数名称和HTTP请求参数名称一致
     * @param intVal
     * @param longVal
     * @param str
     * @return
     */
    //    http://localhost:8080/my/no/annotation?intVal=10&longVal=100
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String,Object> noAnnotation(Integer intVal,Long longVal,String str){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("intVal",intVal);
        paramMap.put("longVal",longVal);
        paramMap.put("str",str);
        return paramMap;
    }

    /**
     * 通过 @RequestParam 获取参数   required = false ：允许空值
     * @param intVal
     * @param longVal
     * @param str
     * @return
     */
    @GetMapping("/annotation")
    @ResponseBody
    public Map<String,Object> repuestParam(
            @RequestParam(value = "int_val",required = false) Integer intVal,
            @RequestParam(value = "long_val",required = false) Long longVal,
            @RequestParam(value = "str_val",required = false) String str){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("intVal",intVal);
        paramMap.put("longVal",longVal);
        paramMap.put("str",str);
        return paramMap;
    }


    /**     http://localhost:8080/my/requestArray?intArr=1,2,3&longArr=10,20,30&strArr=张三,李四
     * 传递数组
     * @param intArr
     * @param longArr
     * @param strArr
     * @return
     */
    @GetMapping("/requestArray")
    @ResponseBody
    public Map<String,Object> requestArray(
            int[] intArr,Long[] longArr,String[] strArr){
        Map<String ,Object> paramMap = new HashMap<>();
        paramMap.put("intArr",intArr);
        paramMap.put("longArr", longArr);
        paramMap.put("strArr", strArr);
        return paramMap;
    }

    /**
     * 获取格式化参数
     */
    //映射 jsp  页面
    @GetMapping("/format/form")
    public String showFormat(){
        return "/format/formatter";
    }

    //获取提交参数
    @PostMapping("/format/commit")
    @ResponseBody
    public Map<String,Object> format(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
            @NumberFormat(pattern = "#,###.##") Double number){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("date",date);
        dataMap.put("number",number);
        return dataMap;
    }

    /**
     * 验证 JSR-303 验证数据功能
     */
    @GetMapping("/valid/page")
    public String validPage(){
        return "/validator/pojo";
    }




}
