package com.ugnius.task.controllers;

import com.ugnius.task.models.Book;
import com.ugnius.task.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/{id}/rate")
    public ResponseEntity<Book> rateBook(@PathVariable Long id, @RequestParam double rating) {
        return ResponseEntity.ok(bookService.rateBook(id, rating));
    }

}
