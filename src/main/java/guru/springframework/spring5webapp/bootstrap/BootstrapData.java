package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private  final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("NNJ Publishing");
        publisher.setAddressLine1("Shahu road");
        publisher.setCity("Pune");
        publisher.setState("MH");
        publisherRepository.save(publisher);

        Author naresh = new Author("Naresh", "Jagadale");
        Book book1 = new Book("Spring Data", "1234567");
        naresh.getBooks().add(book1);
        book1.getAuthors().add(naresh);
        book1.setPublisher(publisher);
        authorRepository.save(naresh);
        bookRepository.save(book1);
        publisher.getBooks().add(book1);
        publisherRepository.save(publisher);

        Author priti = new Author("Priti", "Wadekar");
        Book book2 = new Book("Spring Securities", "9876543");
        priti.getBooks().add(book2);
        book2.getAuthors().add(priti);
        book2.setPublisher(publisher);
        authorRepository.save(priti);
        bookRepository.save(book2);

        publisher.getBooks().add(book2);
        publisherRepository.save(publisher);

        System.out.println("Bootstrap stared and loaded books count:"+ bookRepository.count());
        System.out.println("Publisher book size: "+ publisher.getBooks().size());
    }
}
