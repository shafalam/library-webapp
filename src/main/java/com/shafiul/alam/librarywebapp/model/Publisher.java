package com.shafiul.alam.librarywebapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> publisher_books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getPublisher_books() {
        return publisher_books;
    }

    public void setPublisher_books(Set<Book> publisher_books) {
        this.publisher_books = publisher_books;
    }
}
