package br.com.peoplemanager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.peoplemanager.entities.Person;
import br.com.peoplemanager.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<Iterable<Person>> findAll() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        person.setName(person.getName().toUpperCase());
        return ResponseEntity.ok(personRepository.save(person));
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        person.setName(person.getName().toUpperCase());
        return ResponseEntity.ok(personRepository.save(person));
    }
}
