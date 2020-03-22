package dk.lundudvikling.springdemo.endpoints.person.interfaces.services;

import dk.lundudvikling.springdemo.endpoints.person.models.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(long id);
    List<Person> getPeople();
    Person createPerson (Person person);
    Person updatePerson(Person person);
    void deletePerson(long id);
}
