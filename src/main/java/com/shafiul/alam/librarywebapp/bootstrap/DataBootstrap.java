package com.shafiul.alam.librarywebapp.bootstrap;

import com.shafiul.alam.librarywebapp.model.Author;
import com.shafiul.alam.librarywebapp.model.Book;
import com.shafiul.alam.librarywebapp.model.Publisher;
import com.shafiul.alam.librarywebapp.repository.AuthorRepository;
import com.shafiul.alam.librarywebapp.repository.BookRepository;
import com.shafiul.alam.librarywebapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DataBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }
    private void init(){
        Book b1 = new Book();
        Book b2 = new Book();
        Book b3 = new Book();

        b1.setName("One Hundred Years of Solitude");
        b2.setName("Mysterious Island");
        b3.setName("Thousands League under the Sea");

        Author a1 = new Author();
        Author a2 = new Author();
        Author a3 = new Author();

        a1.setName("Garcia Gabriel Marquez");
        a2.setName("Jules Vernes");
        a3.setName("Jules Vernes");

        Publisher p1 = new Publisher();
        Publisher p2 = new Publisher();
        p1.setName("McGraw Hills");
        p2.setName("Packt Publication");

        b1.setPublisher(p1);
        b2.setPublisher(p2);
        b3.setPublisher(p1);

        Set<Book> books = new HashSet<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);

        a1.setBooks(books);
        a2.setBooks(books);
        a3.setBooks(books);

        Set<Author> authors = new HashSet<>();
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);

        b1.setAuthors(authors);
        b2.setAuthors(authors);
        b3.setAuthors(authors);

        p1.getPublisher_books().add(b1);
        p1.getPublisher_books().add(b3);
        p2.getPublisher_books().add(b2);

        publisherRepository.save(p1);
        publisherRepository.save(p2);

        authorRepository.save(a1);
        authorRepository.save(a2);
        authorRepository.save(a3);

        bookRepository.save(b1);
        bookRepository.save(b2);
        bookRepository.save(b3);




    }
}
