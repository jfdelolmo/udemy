package me.springframework.spring5app.repositories;

import me.springframework.spring5app.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
