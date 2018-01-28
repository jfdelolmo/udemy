package me.springframework.spring5app.repositories;

import me.springframework.spring5app.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long>
{
}
