package com.ugnius.task.services;

import com.ugnius.task.models.Book;
import com.ugnius.task.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> filterBooks(String title, String author, Integer year, Double rating) {
        if (title != null) return bookRepository.findByTitle(title);
        if (author != null) return bookRepository.findByAuthor(author);
        if (year != null) return bookRepository.findByPublicationYear(year);
        if (rating != null) return bookRepository.findByRating(rating);
        return bookRepository.findAll();
    }

    public Book rateBook(Long id, Double rating) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setRating(rating);
        return bookRepository.save(book);
    }
}
