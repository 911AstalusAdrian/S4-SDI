package ro.ubb.relations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.relations.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
