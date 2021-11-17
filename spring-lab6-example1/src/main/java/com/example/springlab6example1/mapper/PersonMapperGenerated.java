package com.example.springlab6example1.mapper;

import com.example.springlab6example1.domain.Person;
import com.example.springlab6example1.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapperGenerated {

    @Mapping(target = "name", source = "person.firstName")
    @Mapping(target = "surname", source = "person.lastName")
    @Mapping(target = "additionalInfo", source = "person.description")
    PersonDto mapToDto(Person person);

    @Mapping(target = "firstName", source = "personDto.name")
    @Mapping(target = "lastName", source = "personDto.surname")
    @Mapping(target = "description", source = "personDto.additionalInfo")
    Person mapToEntity(PersonDto personDto);
}
