package com.example.springlab5example1.controller;

import com.example.springlab5example1.dto.PersonDto;
import com.example.springlab5example1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
    public PersonDto create(@RequestBody PersonDto personDto) {
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

}
