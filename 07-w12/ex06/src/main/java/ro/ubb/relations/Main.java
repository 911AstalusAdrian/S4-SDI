package ro.ubb.relations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.relations.model.Book;
import ro.ubb.relations.model.Publisher;
import ro.ubb.relations.repository.BookRepository;
import ro.ubb.relations.repository.PublisherRepository;

/**
 * Created by radu.
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.relations.config");

        PublisherRepository publisherRepository = context.getBean(PublisherRepository.class);

        BookRepository bookRepository = context.getBean(BookRepository.class);

        Publisher publisher = Publisher.builder()
                .name("manning")
                .build();

        Book book = Book.builder()
                .publisher(publisher)
                .title("a title")
                .author("an author")
                .build();

        bookRepository.save(book);
        publisherRepository.save(publisher);

        System.out.println("hello");
    }
}
