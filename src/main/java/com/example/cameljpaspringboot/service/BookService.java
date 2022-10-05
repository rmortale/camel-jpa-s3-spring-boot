package com.example.cameljpaspringboot.service;

import com.example.cameljpaspringboot.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class BookService {

    private final Random amount = new Random();

    //private final BookRepository repo;

    public Book generateBook() {
        Book book = new Book();
        book.setAuthor("me");
        book.setName("Name" + amount.nextInt());
        return book;
    }
}
