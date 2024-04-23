package br.com.service;

import br.com.domain.Person;
import br.com.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;


@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository personRepository;

    @Inject
    EntityManager entityManager;

    public Person createPerson(Person person){
        entityManager.createNativeQuery("CALL create_person(?, ?)")
                .setParameter(1, person.getName())
                .setParameter(2, person.getAge())
                .executeUpdate();
        return person;
    }


}
