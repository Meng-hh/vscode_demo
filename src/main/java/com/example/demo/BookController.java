package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.utils.RedisUtil;

@RestController
public class BookController{
    @Autowired
    private PersonMapper personMapper;

    @Autowired
	private RedisUtil redisUtil;

    @RequestMapping("/hello")
    @ResponseBody
    public String test01(){
        List<Person>persons=personMapper.findAll();
        persons.forEach((it)->{
            System.out.println(it.getName());
            System.out.println(it.getAge());
        });
        return "Hello world";
    }
    @RequestMapping("/redis")
    @ResponseBody
    public String test02(){
        // redisUtil.set("name", "zhangsan");
        return redisUtil.get("name").toString();
    }
}