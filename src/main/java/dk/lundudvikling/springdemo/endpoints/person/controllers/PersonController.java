package dk.lundudvikling.springdemo.endpoints.person.controllers;

import dk.lundudvikling.springdemo.endpoints.person.interfaces.PersonService;
import dk.lundudvikling.springdemo.endpoints.person.models.Person;
import dk.lundudvikling.springdemo.endpoints.person.services.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("people")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonServiceImpl personServiceImpl) {
        this.personService = personServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPeople(){
        return new ResponseEntity<>(personService.getPeople(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person){
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person){
        return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id){
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable("id") long id){
        personService.deletePerson(id);
        return new ResponseEntity<>("deleted person", HttpStatus.NO_CONTENT);
    }



}
