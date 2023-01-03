package br.com.peoplemanager;

import static org.junit.Assert.assertSame;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.peoplemanager.entities.Person;
import br.com.peoplemanager.repository.PersonRepository;

@SpringBootTest
class PeoplemanagerApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	void testCreatePerson() {
		Person person = new Person();
		LocalDate date = LocalDate.of(2023, Month.JANUARY, 1);
		Long id = (long) 2;
		person.setName("Jhon Doe");
		person.setBirthDay(date);
		personRepository.save(person);

		Person savedPerson = personRepository.findById(person.getId()).get();
		assertSame("Jhon Doe", savedPerson.getName());
		assertSame(id, savedPerson.getId());
	}

}
