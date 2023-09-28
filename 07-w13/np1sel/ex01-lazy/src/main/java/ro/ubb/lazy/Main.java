package ro.ubb.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.lazy.model.Author;
import ro.ubb.lazy.model.Book;
import ro.ubb.lazy.model.Publisher;
import ro.ubb.lazy.service.AuthorService;

import java.util.*;

/**
 * Created by radu.
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.lazy.config");

        AuthorService authorService = context.getBean(AuthorService.class);

//        initData(authorService);

        List<Author> all = authorService.findAll();

        all.forEach(System.out::println);

//        Publisher publisher = new ArrayList<>(all.get(0).getBooks()).get(0).getPublisher();
//        System.out.println(publisher);

        System.out.println("bye");
    }

    private static void initData(AuthorService authorService) {
        Publisher publisher1 = Publisher.builder()
                .name("p1")
                .build();
        Publisher publisher2 = Publisher.builder()
                .name("p2")
                .build();

        Author author1 = Author.builder()
                .name("a1")
                .build();
        Author author2 = Author.builder()
                .name("a2")
                .build();

        Book book1 = Book.builder()
                .title("b1")
                .publisher(publisher1)
                .author(author1)
                .build();
        Book book2 = Book.builder()
                .title("b2")
                .publisher(publisher1)
                .author(author1)
                .build();
        Book book3 = Book.builder()
                .title("b3")
                .publisher(publisher2)
                .author(author2)
                .build();

        author1.setBooks(new HashSet<>(Arrays.asList(book1, book2)));
        author2.setBooks(new HashSet<>(Collections.singletonList(book3)));

        authorService.save(author1);
        authorService.save(author2);

    }
}
