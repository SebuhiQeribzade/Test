package com.example.test.controller;

import com.example.test.service.BookService;
import jakarta.persistence.criteria.Root;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/latest-books")
    public List<Root> getBook(@RequestHeader(name ="x-rapidapi-host")String host,
                              @RequestHeader(name = "x-rapidapi-key")String key,
                              @RequestHeader(name = "bookID")String bookID){

        return bookService.getMessageService(host, key, bookID);
    }
}
