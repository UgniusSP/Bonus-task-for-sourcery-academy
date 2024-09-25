package com.ugnius.task.controllers;

import com.ugnius.task.models.Book;
import com.ugnius.task.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/filter")
    public List<Book> getAllBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) Integer year,
                                  @RequestParam(required = false) Double rating) {
        return bookService.filterBooks(title, author, year, rating);
    }

    @PostMapping("/{id}/rate")
    public ResponseEntity<Book> rateBook(@PathVariable Long id, @RequestParam double rating) {
        if (rating < 1 || rating > 5) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(bookService.rateBook(id, rating));
    }

}
