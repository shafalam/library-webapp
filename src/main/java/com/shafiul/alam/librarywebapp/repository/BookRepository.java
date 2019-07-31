package com.shafiul.alam.librarywebapp.repository;

import com.shafiul.alam.librarywebapp.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
