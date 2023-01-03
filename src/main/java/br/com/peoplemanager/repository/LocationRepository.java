package br.com.peoplemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.peoplemanager.entities.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query(value = "SELECT l FROM Location l WHERE l.person.id = ?1")
    public List<Location> findByPersonId(Long idPerson);
}
