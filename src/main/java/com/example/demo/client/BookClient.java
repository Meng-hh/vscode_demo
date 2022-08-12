package com.example.demo.client;

import com.example.demo.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("BookService")
public interface BookClient {

    @GetMapping("/books/list")
    public List<Book> books();
}
