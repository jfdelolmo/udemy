package me.springframework.spring5app.bootstrap;

import me.springframework.spring5app.model.Author;
import me.springframework.spring5app.model.Book;
import me.springframework.spring5app.model.Publisher;
import me.springframework.spring5app.repositories.AuthorRepository;
import me.springframework.spring5app.repositories.BookRepository;
import me.springframework.spring5app.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher("ThePublisher", "EditorialStreet");
        publisherRepository.save(publisher);

        Author jordi = new Author("Jordi", "Fernandez");
        Book b = new Book("Perico de los palotes","1234", publisher);
        jordi.getBooks().add(b);
        b.getAuthors().add(jordi);

        authorRepository.save(jordi);
        bookRepository.save(b);

        Author otro = new Author("Otro", "Nosoyjordi");
        Book bb = new Book("Un libro qualquiera", "9876", publisher);
        otro.getBooks().add(bb);
       bb.getAuthors().add(otro);

        authorRepository.save(otro);
        bookRepository.save(bb);
    }
}
