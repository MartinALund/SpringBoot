package dk.lundudvikling.springdemo.personService.person.interfaces.controllers;

import dk.lundudvikling.springdemo.personService.person.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("people")
@CrossOrigin("http://localhost:4200")
public interface PersonController {

    @GetMapping()
    default ResponseEntity<List<Person>> getPeople(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("three")
    default ResponseEntity<List<Person>> getPeopleWithIdLessthanThree(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("starts/{startingLetter}")
    default ResponseEntity<List<Person>> getPeopleStartingWithLetter(@PathVariable("startingLetter") String startingLetter){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("like/{input}")
    default ResponseEntity<List<Person>> getPeopleLikeInput(@PathVariable("input") String input){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("like/custom/{input}")
    default ResponseEntity<List<Person>> getPeopleCustomAgeQuery(@PathVariable("input") String input){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping()
    default ResponseEntity<Person> createPerson(@Valid @RequestBody Person person){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping()
    default ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("{id}")
    default ResponseEntity<Person> getPersonById(@PathVariable("id") long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("{id}")
    default ResponseEntity<?> deletePersonById(@PathVariable("id") long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
