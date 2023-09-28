package ro.ubb.relations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.relations.model.Battery;
import ro.ubb.relations.model.Product;
import ro.ubb.relations.repository.ProductRepository;

/**
 * Created by radu.
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.relations.config");

        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Product product = Product.builder()
                .name("product1")
                .build();

        Battery battery = new Battery("battery1", true);

        productRepository.save(product);
        productRepository.save(battery);

        productRepository.findAll().stream().forEach(System.out::println);

        System.out.println("hello");
    }
}
