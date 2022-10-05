package com.example.cameljpaspringboot.service;

import com.example.cameljpaspringboot.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
