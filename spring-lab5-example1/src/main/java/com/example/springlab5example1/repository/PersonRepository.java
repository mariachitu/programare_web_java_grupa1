package com.example.springlab5example1.repository;

import com.example.springlab5example1.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> persons = new ArrayList<>();

    public PersonRepository() {
        setupInitialData();
    }

    public List<Person> getAll() {
        return persons;
    }

    public Person save(Person person) {
        persons.add(person);
        return person;
    }

    public void delete(Person person) {
        persons.remove(person);
    }

    private void setupInitialData() {
        Person person = Person.builder()
                .firstName("Maria")
                .lastName("Chitu")
                .description("First user")
                .build();
        persons.add(person);

        Person anotherPerson = Person.builder()
                .firstName("Dan")
                .lastName("Ionescu")
                .description("Second user")
                .build();
        persons.add(anotherPerson);
    }
}
