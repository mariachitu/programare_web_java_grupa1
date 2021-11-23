package com.example.springlab6example1.service;

import com.example.springlab6example1.domain.Person;
import com.example.springlab6example1.dto.PersonDto;
import com.example.springlab6example1.exception.NoDataFoundException;
import com.example.springlab6example1.exception.PersonNotFoundException;
import com.example.springlab6example1.mapper.PersonMapper;
import com.example.springlab6example1.mapper.PersonMapperGenerated;
import com.example.springlab6example1.repository.PersonRepository;
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

    @Autowired
    private PersonMapperGenerated mapperGenerated;

    public List<PersonDto> getAllPersons() {
        List<PersonDto> personDtos = repository.getAll()
                .stream()
                .map(person -> mapperGenerated.mapToDto(person))
                .collect(Collectors.toList());

        if (personDtos.isEmpty()) {
            throw new NoDataFoundException("No data found");
        }
        return personDtos;
    }

    public PersonDto save(PersonDto personDto) {
        Person person = mapperGenerated.mapToEntity(personDto);
        Person personSaved = repository.save(person);
        return mapperGenerated.mapToDto(personSaved);
    }

    public boolean deleteFirst(String surname) {
        Optional<Person> optionalPerson = repository.getAll().stream()
                .filter(person -> person.getLastName().equals(surname))
                .findFirst();
        if (optionalPerson.isPresent()) {
            repository.delete(optionalPerson.get());
            return true;
        }
        throw new PersonNotFoundException("Person not found");
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

    public PersonDto updateEntireDto(PersonDto personDto, String lastName) {
        Person person = repository.updateEntirePerson(mapper.mapToEntity(personDto), lastName);
        return mapper.mapToDto(person);
    }

    public PersonDto updatePartialDto(PersonDto personDto, String lastName) {
        Person person = repository.updatePartialPerson(mapper.mapToEntity(personDto), lastName);
        return mapper.mapToDto(person);
    }

    public PersonDto updateLastNamePerson(String lastName, String newLastName) {
        Person person = repository.updatePersonName(lastName, newLastName);
        return mapper.mapToDto(person);
    }

    public List<PersonDto> filter(String firstName, String lastName) {
        List<Person> persons = repository.getFilteredPersons(firstName, lastName);
        return persons.stream().map(p -> mapper.mapToDto(p)).collect(Collectors.toList());
    }
}
