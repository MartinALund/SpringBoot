package dk.lundudvikling.springdemo.people.implementations.services;

import dk.lundudvikling.springdemo.people.interfaces.services.PersonService;
import dk.lundudvikling.springdemo.people.models.Person;
import dk.lundudvikling.springdemo.people.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person getPerson(long id) {
        return repository.getPersonById(id);
    }

    @Override
    public List<Person> getPeople() {
        return repository.findAll();
    }

    @Override
    public List<Person> getPeopleWithIdLessThanThree() {
        return repository.getPeopleWhereIdIsLessThanThree();
    }

    @Override
    public List<Person> getPeopleWithStartingLetter(String startingLetter) {
        return repository.findByFirstNameStartingWithIgnoreCase(startingLetter);
    }

    @Override
    public List<Person> getPeopleLikeInput(String input) {
        return repository.findPeopleByFirstNameContainingIgnoreCase(input);
    }

    @Override
    public List<Person> getPeopleByCustomLastNameQuery(String input) {
        return repository.getPeopleByCustomLastNameQuery(input);
    }

    @Override
    public Person createPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return repository.save(person);
    }

    @Override
    public void deletePerson(long id) {
        repository.deletePersonById(id);
    }
}
