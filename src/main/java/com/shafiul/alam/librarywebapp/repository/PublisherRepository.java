package com.shafiul.alam.librarywebapp.repository;

import com.shafiul.alam.librarywebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
