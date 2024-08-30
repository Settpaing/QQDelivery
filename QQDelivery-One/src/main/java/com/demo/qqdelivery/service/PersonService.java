package com.demo.qqdelivery.service;

import com.demo.qqdelivery.entity.Person;
import com.demo.qqdelivery.repository.PersonRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        person.setCreatedBy(username);
        person.setCreatedOn(LocalDateTime.now());
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}

