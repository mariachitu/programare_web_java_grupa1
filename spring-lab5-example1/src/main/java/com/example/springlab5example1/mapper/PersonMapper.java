package com.example.springlab5example1.mapper;

import com.example.springlab5example1.domain.Person;
import com.example.springlab5example1.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDto mapToDto(Person person) {
        return PersonDto.builder()
                .name(person.getFirstName())
                .surname(person.getLastName())
                .additionalInfo(person.getDescription())
                .build();
    }

    public Person mapToEntity(PersonDto personDto) {
        return Person.builder()
                .firstName(personDto.getName())
                .lastName(personDto.getSurname())
                .description(personDto.getAdditionalInfo())
                .build();
    }
}
