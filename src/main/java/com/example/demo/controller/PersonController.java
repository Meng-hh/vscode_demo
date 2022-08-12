package com.example.demo.controller;

import java.util.List;

import com.example.demo.client.BookClient;
import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.utils.RedisUtil;

@RestController
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
	private RedisUtil redisUtil;

    @Autowired
    private BookClient bookClient;

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

    @RequestMapping("books")
    public List<Book> test03(){
        return bookClient.books();
    }
}