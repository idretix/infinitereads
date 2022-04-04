package com.example.infinitereads.book;

import com.example.infinitereads.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunnerBook(
            BookRepository repository){
        return args->{
           Book book1 = new Book(
                    "Infinite Jest",
                    "David Foster Wallace",
                    "9780316921176"
            );

        };
    }
}