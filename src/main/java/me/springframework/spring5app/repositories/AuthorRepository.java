package me.springframework.spring5app.repositories;

import me.springframework.spring5app.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
