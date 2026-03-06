package guru.springframework.spring_6_webapp.boostrap;

import guru.springframework.spring_6_webapp.domain.Author;

import guru.springframework.spring_6_webapp.domain.Book;

import guru.springframework.spring_6_webapp.domain.Publisher;

import guru.springframework.spring_6_webapp.repositories.AuthorRepository;

import guru.springframework.spring_6_webapp.repositories.BookRepository;

import guru.springframework.spring_6_webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

@Component

public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository,

                        PublisherRepository publisherRepository) {

        this.authorRepository = authorRepository;

        this.bookRepository = bookRepository;

        this.publisherRepository = publisherRepository;

    }

    @Override

    public void run(String... args) throws Exception {


        // AUTORES
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Author martin = new Author();
        martin.setFirstName("Martin");
        martin.setLastName("Fowler");

        Author josh = new Author();
        josh.setFirstName("Josh");
        josh.setLastName("Bloch");

        Author kent = new Author();
        kent.setFirstName("Kent");
        kent.setLastName("Beck");



        // LIBROS
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Book refactoring = new Book();
        refactoring.setTitle("Refactoring");
        refactoring.setIsbn("111111");

        Book cleanCode = new Book();
        cleanCode.setTitle("Clean Code");
        cleanCode.setIsbn("222222");

        Book effectiveJava = new Book();
        effectiveJava.setTitle("Effective Java");
        effectiveJava.setIsbn("333333");

        Book tdd = new Book();
        tdd.setTitle("Test Driven Development");
        tdd.setIsbn("444444");

        Book patterns = new Book();
        patterns.setTitle("Enterprise Patterns");
        patterns.setIsbn("555555");

        Book agile = new Book();
        agile.setTitle("Agile Software Development");
        agile.setIsbn("666666");



        // EDITORIALES
        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");

        Publisher techBooks = new Publisher();
        techBooks.setPublisherName("Tech Books");
        techBooks.setAddress("456 Tech Street");

        Publisher codePress = new Publisher();
        codePress.setPublisherName("Code Press");
        codePress.setAddress("789 Code Avenue");



        // GUARDAR AUTORES
        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);
        Author martinSaved = authorRepository.save(martin);
        Author joshSaved = authorRepository.save(josh);
        Author kentSaved = authorRepository.save(kent);


        // GUARDAR LIBROS
        Book dddSaved = bookRepository.save(ddd);
        Book noEJBSaved = bookRepository.save(noEJB);
        Book refactoringSaved = bookRepository.save(refactoring);
        Book cleanCodeSaved = bookRepository.save(cleanCode);
        Book effectiveJavaSaved = bookRepository.save(effectiveJava);
        Book tddSaved = bookRepository.save(tdd);
        Book patternsSaved = bookRepository.save(patterns);
        Book agileSaved = bookRepository.save(agile);


        // GUARDAR EDITORIALES
        Publisher savedPublisher = publisherRepository.save(publisher);
        Publisher savedTechBooks = publisherRepository.save(techBooks);
        Publisher savedCodePress = publisherRepository.save(codePress);


        // RELACIONES AUTOR - LIBRO
        ericSaved.getBooks().add(dddSaved);
        dddSaved.getAuthors().add(ericSaved);
        rodSaved.getBooks().add(noEJBSaved);
        noEJBSaved.getAuthors().add(rodSaved);
        martinSaved.getBooks().add(refactoringSaved);
        refactoringSaved.getAuthors().add(martinSaved);
        martinSaved.getBooks().add(patternsSaved);
        patternsSaved.getAuthors().add(martinSaved);
        joshSaved.getBooks().add(effectiveJavaSaved);
        effectiveJavaSaved.getAuthors().add(joshSaved);
        kentSaved.getBooks().add(tddSaved);
        tddSaved.getAuthors().add(kentSaved);
        kentSaved.getBooks().add(cleanCodeSaved);
        cleanCodeSaved.getAuthors().add(kentSaved);
        rodSaved.getBooks().add(agileSaved);
        agileSaved.getAuthors().add(rodSaved);


        // RELACIONES LIBRO - EDITORIAL
        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);
        refactoringSaved.setPublisher(savedTechBooks);
        patternsSaved.setPublisher(savedTechBooks);
        effectiveJavaSaved.setPublisher(savedTechBooks);
        cleanCodeSaved.setPublisher(savedCodePress);
        tddSaved.setPublisher(savedCodePress);
        agileSaved.setPublisher(savedCodePress);



        // RELACIONES
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        authorRepository.save(martinSaved);
        authorRepository.save(joshSaved);
        authorRepository.save(kentSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);
        bookRepository.save(refactoringSaved);
        bookRepository.save(cleanCodeSaved);
        bookRepository.save(effectiveJavaSaved);
        bookRepository.save(tddSaved);
        bookRepository.save(patternsSaved);
        bookRepository.save(agileSaved);



        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}