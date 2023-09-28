package ro.ubb.crud;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.crud.model.Person;
import ro.ubb.crud.repository.PersonRepository;

import java.util.List;

/**
 * Created by radu.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.crud.config");

        PersonRepository personRepository = context.getBean(
                PersonRepository.class);

        personRepository.save(new Person(null, "Marian"));
        List<Person> persons = personRepository.getPersonsByName("Marian");
        //System.out.println(persons);
        Person person1 = persons.get(0);
        System.out.println("FindById1 starts here: ");
        Person retrieved = personRepository.findById1(person1.getId());
        System.out.println(retrieved);

        System.out.println("FindById2 starts here: ");
        Person retrieved2 = personRepository.findById2(person1.getId());
        System.out.println(retrieved2);

        personRepository.update(person1);

        personRepository.merge1(person1);

        personRepository.merge2(new Person(null, "nameee"));

        personRepository.deleteById(person1.getId());

        System.out.println("bye");
    }
}
