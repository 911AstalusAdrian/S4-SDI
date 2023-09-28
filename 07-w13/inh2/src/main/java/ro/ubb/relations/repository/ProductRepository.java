package ro.ubb.relations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.relations.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
