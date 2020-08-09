package dk.lundudvikling.springdemo.people.interfaces.services;

import dk.lundudvikling.springdemo.people.exceptions.JpaException;
import dk.lundudvikling.springdemo.people.models.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(long id) throws JpaException;
    List<Person> getPeople() throws JpaException;
    List<Person> getPeopleWithIdLessThanThree() throws JpaException;
    List<Person> getPeopleWithStartingLetter(String startingLetter) throws JpaException;
    List<Person> getPeopleLikeInput(String input) throws JpaException;
    List<Person> getPeopleByCustomLastNameQuery(String age) throws JpaException;
    Person createPerson (Person person) throws JpaException;
    Person updatePerson(Person person) throws JpaException;
    void deletePerson(long id) throws JpaException;
}
