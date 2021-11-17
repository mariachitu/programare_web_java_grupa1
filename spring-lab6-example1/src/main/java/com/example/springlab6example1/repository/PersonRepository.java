package com.example.springlab6example1.repository;

import com.example.springlab6example1.domain.Person;
import com.example.springlab6example1.exception.PersonNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Person updateEntirePerson(Person person, String lastName) {
        Person existingPerson = this.persons.stream().filter(pers -> pers.getLastName().equals(lastName)).findFirst()
                .orElseThrow(() -> new PersonNotFoundException("Person not found!"));
        persons.remove(existingPerson);
        persons.add(person);
        return person;
    }

    public Person updatePartialPerson(Person person, String lastName) {
        Person existingPerson = this.persons.stream().filter(pers -> pers.getLastName().equals(lastName)).findFirst()
                .orElseThrow(() -> new PersonNotFoundException("Person not found!"));
        persons.remove(existingPerson);
        existingPerson.setFirstName(person.getFirstName() != null ? person.getFirstName() : existingPerson.getFirstName());
        existingPerson.setLastName(person.getLastName() != null ? person.getLastName() : existingPerson.getLastName());
        existingPerson.setDescription(person.getDescription() != null ? person.getDescription() : existingPerson.getDescription());
        persons.add(existingPerson);
        return existingPerson;
    }

    public Person updatePersonName(String lastName, String updatedName) {
        Person existingPerson = this.persons.stream().filter(pers -> pers.getLastName().equals(lastName)).findFirst()
                .orElseThrow(() -> new PersonNotFoundException("Person not found!"));
        persons.remove(existingPerson);
        existingPerson.setLastName(updatedName);
        persons.add(existingPerson);
        return existingPerson;
    }

    public List<Person> getFilteredPersons(String firstName, String lastName) {
        return getAll()
                .stream()
                .filter(person -> person.getFirstName().equals(firstName))
                .filter(person -> person.getLastName().equals(lastName))
                .collect(Collectors.toList());
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
