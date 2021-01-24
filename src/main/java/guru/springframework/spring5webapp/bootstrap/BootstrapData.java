package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author naresh = new Author("Naresh", "Jagadale");
        Book book1 = new Book("Spring Data", "1234567");
        naresh.getBooks().add(book1);
        book1.getAuthors().add(naresh);
        authorRepository.save(naresh);
        bookRepository.save(book1);

        Author priti = new Author("Priti", "Wadekar");
        Book book2 = new Book("Spring Securities", "9876543");
        priti.getBooks().add(book2);
        book2.getAuthors().add(priti);
        authorRepository.save(priti);
        bookRepository.save(book2);

        System.out.println("Bootstrap stared and loaded books count:"+ bookRepository.count());
    }
}
