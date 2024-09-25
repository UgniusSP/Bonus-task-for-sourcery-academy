package com.ugnius.task.config;

import com.ugnius.task.models.Book;
import com.ugnius.task.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book(null, "The Catcher in the Rye", "J.D. Salinger", 1951, null));
            bookRepository.save(new Book(null, "1984", "George Orwell", 1949, null));
            bookRepository.save(new Book(null, "The Great Gatsby", "F. Scott Fitzgerald", 1925, null));
            bookRepository.save(new Book(null, "The Bible", "Jesus", 0, null));
        };
    }
}
