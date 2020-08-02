package dk.lundudvikling.springdemo.personService.person.controllers;

import dk.lundudvikling.springdemo.personService.person.interfaces.services.PersonService;
import dk.lundudvikling.springdemo.personService.person.models.Person;
import dk.lundudvikling.springdemo.personService.person.services.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("people")
@CrossOrigin("http://localhost:4200")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonServiceImpl personServiceImpl) {
        this.personService = personServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getPeople(){
        return new ResponseEntity<>(personService.getPeople(), HttpStatus.OK);
    }

    @GetMapping("three")
    public ResponseEntity<List<Person>> getPeopleWithIdLessthanThree(){
        return new ResponseEntity<>(personService.getPeopleWithIdLessThanThree(), HttpStatus.OK);
    }

    @GetMapping("starts/{startingLetter}")
    public ResponseEntity<List<Person>> getPeopleStartingWithLetter(@PathVariable("startingLetter") String startingLetter){
        return new ResponseEntity<>(personService.getPeopleWithStartingLetter(startingLetter), HttpStatus.OK);
    }

    @GetMapping("like/{input}")
    public ResponseEntity<List<Person>> getPeopleLikeInput(@PathVariable("input") String input){
        return new ResponseEntity<>(personService.getPeopleLikeInput(input), HttpStatus.OK);
    }

    @GetMapping("like/custom/{input}")
    public ResponseEntity<List<Person>> getPeopleCustomAgeQuery(@PathVariable("input") String input){
        return new ResponseEntity<>(personService.getPeopleByCustomLastNameQuery(input), HttpStatus.OK);
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
