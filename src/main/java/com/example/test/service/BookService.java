package com.example.test.service;

import com.example.test.client.BookClient;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
@AllArgsConstructor

public class BookService {
    private final BookClient bookClient;

    public List<Root> getMessageService(@RequestHeader(name ="x-rapidapi-host")String host,
                                        @RequestHeader(name = "x-rapidapi-key")String key,
                                        @RequestHeader(name = "bookID")String bookID){
       return bookClient.getBooks(host, key, bookID);
    }
}
