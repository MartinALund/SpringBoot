package dk.lundudvikling.springdemo.people.implementations.controllers;

import dk.lundudvikling.springdemo.people.exceptions.JpaException;
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
        try {
            return new ResponseEntity<>(personService.getPeople(), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<List<Person>> getPeopleWithIdLessthanThree(){
        try {
            return new ResponseEntity<>(personService.getPeopleWithIdLessThanThree(), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Person>> getPeopleStartingWithLetter(@PathVariable("startingLetter") String startingLetter){
        try {
            return new ResponseEntity<>(personService.getPeopleWithStartingLetter(startingLetter), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Person>> getPeopleLikeInput(@PathVariable("input") String input){
        try {
            return new ResponseEntity<>(personService.getPeopleLikeInput(input), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Person>> getPeopleCustomAgeQuery(@PathVariable("input") String input){
        try {
            return new ResponseEntity<>(personService.getPeopleByCustomLastNameQuery(input), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person){
        try {
            return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person){
        try {
            return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deletePersonById(@PathVariable("id") long id){
        try {
            personService.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}