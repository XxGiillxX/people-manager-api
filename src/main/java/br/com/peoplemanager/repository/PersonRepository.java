package br.com.peoplemanager.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.peoplemanager.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
