package com.shafiul.alam.librarywebapp.repository;

import com.shafiul.alam.librarywebapp.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
