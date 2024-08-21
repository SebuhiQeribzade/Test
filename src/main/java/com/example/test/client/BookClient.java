package com.example.test.client;

import jakarta.persistence.criteria.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "book-service",url = "https://goodreads12.p.rapidapi.com/getAuthorBooks ")
public interface BookClient {

    @GetMapping("/getBooks")
    List<Root> getBooks(
            @RequestHeader(name ="x-rapidapi-host")String host,
            @RequestHeader(name = "x-rapidapi-key")String key,
            @RequestHeader(name = "bookID")String bookID
    );
}
