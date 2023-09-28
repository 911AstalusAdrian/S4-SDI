package ro.ubb.crud.repository;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ubb.crud.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void save(Person person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(person);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<Person> getPersonsByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Person> query = entityManager.createQuery(
                "select p from Person p where p.name=?1",
                Person.class);
        query.setParameter(1, name);
        List<Person> persons = query.getResultList();

        //transaction.commit();
        entityManager.close();

        return persons;
    }

    @Override
    public Person findById1(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Person retrievedPerson = entityManager.find(Person.class, id);
        System.out.println("Retrieved person: ");
        //System.out.println(retrievedPerson);

        Person retrievedPerson1 = entityManager.find(Person.class, id);
        System.out.println("Retrieved person: ");
        System.out.println(retrievedPerson1);

        entityManager.close();

        return retrievedPerson;
    }

    @Override
    public Person findById2(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Person retrievedPerson = entityManager.getReference(Person.class, id);
        System.out.println("Retrieved person: ");
        //System.out.println(retrievedPerson);

        Person retrievedPerson1 = entityManager.getReference(Person.class, id);
        System.out.println("Retrieved person1: ");
        System.out.println(retrievedPerson1);

        entityManager.close();

        return retrievedPerson;
    }

    @Override
    public void update(Person person) {
        //person detached

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Person update = entityManager.getReference(Person.class, person.getId());
        update.setName("update");

        transaction.commit();
        entityManager.close();
    }


    @Override
    public void merge1(Person person) {
        //person - detached

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        person.setName("newNameMerge1");
        entityManager.merge(person);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void merge2(Person person) {
        //person - transient
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        person.setName("newNameMerge2");
        entityManager.merge(person);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Person person = entityManager.getReference(Person.class, id);
        entityManager.remove(person);

        transaction.commit();
        entityManager.close();
    }
}
