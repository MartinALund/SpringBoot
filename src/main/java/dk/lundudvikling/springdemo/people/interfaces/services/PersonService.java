package dk.lundudvikling.springdemo.people.interfaces.services;

import dk.lundudvikling.springdemo.people.models.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(long id);
    List<Person> getPeople();
    List<Person> getPeopleWithIdLessThanThree();
    List<Person> getPeopleWithStartingLetter(String startingLetter);
    List<Person> getPeopleLikeInput(String input);
    List<Person> getPeopleByCustomLastNameQuery(String age);
    Person createPerson (Person person);
    Person updatePerson(Person person);
    void deletePerson(long id);
}
