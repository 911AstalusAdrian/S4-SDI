package ro.ubb.crud.repository;

import ro.ubb.crud.model.Person;

import java.util.List;

/**
 * Created by radu.
 */
public interface PersonRepository {

    void save(Person person);

    List<Person> getPersonsByName(String name);

    //em.find()
    Person findById1(Long id);

    //em.getReference()
    Person findById2(Long id);

    //person - detached
    void update(Person person);

    void deleteById(Long id);

    //person - detached
    void merge1(Person person);

    //person - transient
    void merge2(Person person);
}
