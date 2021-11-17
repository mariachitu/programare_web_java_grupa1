package com.example.springlab6example1.controller;

import com.example.springlab6example1.dto.PersonDto;
import com.example.springlab6example1.exception.PersonNotFoundException;
import com.example.springlab6example1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("")
    public List<PersonDto> getAll() {
        return service.getAllPersons();
    }

    @PostMapping()
    public PersonDto create(@Valid @RequestBody PersonDto personDto) {
        return service.save(personDto);
    }

//    @DeleteMapping("/first/{surname}")
//    public String removeFirst(@PathVariable("surname") String surname) {
//        boolean result = service.deleteFirst(surname);
//        return result ? String.format("Person %s was removed", surname) : String.format("Person %s was not removed", surname);
//    }

    @DeleteMapping("/first/{surname}")
    public String removeFirst(@PathVariable("surname") String surname, HttpServletResponse response) {
        boolean result = service.deleteFirst(surname);
        if (result) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return String.format("Person %s was removed", surname);
        } else {
            response.setStatus(404);
            return String.format("Person %s was not removed", surname);
        }
    }

    @DeleteMapping("/all/{surname}")
    public String removeAll(@PathVariable("surname") String surname) {
        boolean result = service.deleteAll(surname);
        return result ? "All removed" : "None removed";
    }

    @PutMapping("/{lastName}")
    public ResponseEntity<PersonDto> update(@Valid @RequestBody PersonDto personDto, @PathVariable String lastName) {
        try {
            return ResponseEntity.ok(service.updateEntireDto(personDto, lastName));
        } catch (PersonNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PatchMapping("/{lastName}")
    public ResponseEntity<PersonDto> updatePartial(@RequestBody PersonDto personDto, @PathVariable String lastName) {
        try {
            return ResponseEntity.ok(service.updatePartialDto(personDto, lastName));
        } catch (PersonNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PatchMapping("/{lastName}/{newLastName}")
    public ResponseEntity<PersonDto> updatePartial(@PathVariable String lastName, @PathVariable String newLastName) {
        try {
            return ResponseEntity.ok(service.updateLastNamePerson(lastName, newLastName));
        } catch (PersonNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/filter")
    public List<PersonDto> filterPersons(@RequestParam String firstName, @RequestParam String lastName) {
        return service.filter(firstName, lastName);
    }

    @GetMapping("/demo")
    public ResponseEntity<PersonDto> getDemoPerson() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("user", "student")
                .body(new PersonDto("Ionel", "Popescu", "demo user"));
    }

}
