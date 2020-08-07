package dk.lundudvikling.springdemo.people.implementations.controllers;

import dk.lundudvikling.springdemo.people.implementations.services.PersonServiceImpl;
import dk.lundudvikling.springdemo.people.interfaces.controllers.PersonController;
import dk.lundudvikling.springdemo.people.interfaces.services.PersonService;
import dk.lundudvikling.springdemo.people.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonControllerImpl implements PersonController {

    private PersonService personService;

    public PersonControllerImpl(PersonServiceImpl personServiceImpl) {
        this.personService = personServiceImpl;
    }

    @Override
    public ResponseEntity<List<Person>> getPeople(){
        return new ResponseEntity<>(personService.getPeople(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Person>> getPeopleWithIdLessthanThree(){
        return new ResponseEntity<>(personService.getPeopleWithIdLessThanThree(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Person>> getPeopleStartingWithLetter(@PathVariable("startingLetter") String startingLetter){
        return new ResponseEntity<>(personService.getPeopleWithStartingLetter(startingLetter), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Person>> getPeopleLikeInput(@PathVariable("input") String input){
        return new ResponseEntity<>(personService.getPeopleLikeInput(input), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Person>> getPeopleCustomAgeQuery(@PathVariable("input") String input){
        return new ResponseEntity<>(personService.getPeopleByCustomLastNameQuery(input), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person){
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person){
        return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id){
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deletePersonById(@PathVariable("id") long id){
        personService.deletePerson(id);
        return new ResponseEntity<>("deleted person", HttpStatus.NO_CONTENT);
    }



}
