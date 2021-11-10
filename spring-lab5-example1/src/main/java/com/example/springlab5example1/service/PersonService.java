package com.example.springlab5example1.service;

import com.example.springlab5example1.domain.Person;
import com.example.springlab5example1.dto.PersonDto;
import com.example.springlab5example1.mapper.PersonMapper;
import com.example.springlab5example1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    public List<PersonDto> getAllPersons() {
        return repository.getAll()
                .stream()
                .map(person -> mapper.mapToDto(person))
                .collect(Collectors.toList());
    }

    public PersonDto save(PersonDto personDto) {
        Person person = mapper.mapToEntity(personDto);
        Person personSaved = repository.save(person);
        return mapper.mapToDto(personSaved);
    }

    public boolean deleteFirst(String surname) {
        Optional<Person> optionalPerson = repository.getAll().stream()
                .filter(person -> person.getLastName().equals(surname))
                .findFirst();
        if (optionalPerson.isPresent()) {
            repository.delete(optionalPerson.get());
            return true;
        }
        return false;
    }

    public boolean deleteAll(String surname) {
        List<Person> foundPersons = repository.getAll().stream()
                .filter(person -> person.getLastName().equals(surname))
                .collect(Collectors.toList());

        for (Person person : foundPersons) {
            repository.delete(person);
        }

        if (foundPersons.isEmpty()) {
            return false;
        }
        return true;
    }
}
