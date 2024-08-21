package com.example.test.dto.response.goodReadsDto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Root {
    public String imageUrl;
    public String bookId;
    public String workId;
    public String bookUrl;
    public String title;
    public ArrayList<Author> author;
    public String rating;
    public String totalRatings;
    public String publishedYear;
    public String totalEditions;
}
