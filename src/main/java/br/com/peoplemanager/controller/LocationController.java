package br.com.peoplemanager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.peoplemanager.entities.Location;
import br.com.peoplemanager.entities.LocationRequest;
import br.com.peoplemanager.entities.Person;
import br.com.peoplemanager.repository.LocationRepository;
import br.com.peoplemanager.repository.PersonRepository;

@RestController
@RequestMapping("/locations")
@CrossOrigin
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Location> create(@RequestBody LocationRequest locationRequest) {
        Location location = new Location();
        location.setCity(locationRequest.getCity().toUpperCase());
        location.setIsMain(locationRequest.getIsMain());
        location.setNumber(locationRequest.getNumber());
        location.setState(locationRequest.getState().toUpperCase());
        location.setStreetAddress(locationRequest.getStreetAddress().toUpperCase());
        location.setZipCode(locationRequest.getZipCode());
        Optional<Person> person = personRepository.findById(locationRequest.getIdPerson());
        location.setPerson(person.get());
        return ResponseEntity.ok(locationRepository.save(location));
    }

    @GetMapping("/{idPerson}")
    public ResponseEntity<Iterable<Location>> findByPersonId(@PathVariable Long idPerson) {
        return ResponseEntity.ok(locationRepository.findByPersonId(idPerson));
    }
}
