package dk.lundudvikling.springdemo.personService.person.services;

import dk.lundudvikling.springdemo.personService.person.interfaces.services.PersonService;
import dk.lundudvikling.springdemo.personService.person.models.Person;
import dk.lundudvikling.springdemo.personService.person.repositories.PersonRepository;
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
