package guru.springframework.spring_6_webapp.boostrap;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.domain.Publisher;
import guru.springframework.spring_6_webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring_6_webapp.domain.repositories.BookRepository;
import guru.springframework.spring_6_webapp.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Torres");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        Publisher publi1 = new Publisher();
        publi1.setPublisherName("Editorial 1");
        publi1.setAddress("Calle Mayor 15");
        publi1.setCity("Madrid");
        publi1.setState("Madrid");
        publi1.setZip(28001);
        Publisher publi1Saved = publisherRepository.save(publi1);

        Publisher publi2 = new Publisher();
        publi2.setPublisherName("Editorial 2");
        publi2.setAddress("Calle Menor 15");
        publi2.setCity("Toledo");
        publi2.setState("Toledo");
        publi2.setZip(95472);
        Publisher publi2Saved = publisherRepository.save(publi2);

        dddSaved.setPublisher(publi1Saved);
        noEJBSaved.setPublisher(publi2Saved);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);


        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        publisherRepository.save(publi1Saved);
        publisherRepository.save(publi2Saved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count:" + authorRepository.count());
        System.out.println("Book Count:" + bookRepository.count());
        System.out.println("Publisher Count:" + publisherRepository.count());
        System.out.println(publi1);





    }
}
