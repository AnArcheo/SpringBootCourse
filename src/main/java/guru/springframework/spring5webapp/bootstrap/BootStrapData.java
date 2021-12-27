package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.IAuthorRepository;
import guru.springframework.spring5webapp.repositories.IBookRepository;
import guru.springframework.spring5webapp.repositories.IPublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  // spring boot component
public class BootStrapData implements CommandLineRunner {

    // dependency injection
    private final IAuthorRepository authorRepository;
    private final IBookRepository bookRepository;
    private final IPublisherRepository publisherRepository;

    public BootStrapData(IAuthorRepository authorRepository, IBookRepository bookRepository, IPublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher();
        publisher1.setName("Helios");
        publisher1.setCity("New York");
        publisher1.setState("NY");
        publisherRepository.save(publisher1);

        Author tom = new Author("Tom", "Hawkins");
        Book book1 = new Book("Sparrow", "908765");
        tom.getBooks().add(book1);
        book1.getAuthors().add(tom);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        // save to H2 database
        authorRepository.save(tom);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);

        Author stephen = new Author("Stephen", "King");
        Book book2 = new Book("Green Mile", "563421");
        stephen.getBooks().add(book2);
        book2.getAuthors().add(stephen);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);

        // save to H2 database
        authorRepository.save(stephen);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);


        //start message
        System.out.println("started in bootstrap");
        System.out.println("Number of books in repository: " + bookRepository.count());
        System.out.println("Number of authors in repository: " + authorRepository.count());
        System.out.println("Publisher:"+ publisher1.getName() + " have " + publisherRepository.count() + " no. of books");







    }
}
