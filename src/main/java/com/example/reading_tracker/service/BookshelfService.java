package com.example.reading_tracker.service;

import com.example.reading_tracker.bean.Bookshelf;
import com.example.reading_tracker.repository.BookshelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookshelfService {

    @Autowired
    BookshelfRepository bookshelfRepository;

    public List<Bookshelf> findAllByUser(Long userId){
        return bookshelfRepository.findAllByUserId(userId);
    }

    public Bookshelf save(Bookshelf bookshelf){
        return bookshelfRepository.save(bookshelf);
    }

    public List<Bookshelf> getAllBookshelves(){
        return bookshelfRepository.findAll();
    }
}
