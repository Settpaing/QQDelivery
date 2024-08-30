package com.demo.qqdelivery.controller;

import com.demo.qqdelivery.entity.Person;
import com.demo.qqdelivery.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.savePerson(person));
    }

    @GetMapping("/")
    public ResponseEntity<List<Person>> getPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }
}

