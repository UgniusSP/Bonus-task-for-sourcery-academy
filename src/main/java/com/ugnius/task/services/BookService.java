package com.ugnius.task.services;

import com.ugnius.task.models.Book;
import com.ugnius.task.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book rateBook(Long id, Double rating) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setRating(rating);
        return bookRepository.save(book);
    }
}
