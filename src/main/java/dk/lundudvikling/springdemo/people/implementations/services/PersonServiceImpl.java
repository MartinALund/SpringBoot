package dk.lundudvikling.springdemo.people.implementations.services;

import dk.lundudvikling.springdemo.people.exceptions.JpaException;
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
    public Person getPerson(long id) throws JpaException {
        try{
            return repository.getPersonById(id);
        }catch (Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public List<Person> getPeople() throws JpaException {
        try{
            return repository.findAll();
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public List<Person> getPeopleWithIdLessThanThree() throws JpaException {
        try{
            return repository.getPeopleWhereIdIsLessThanThree();
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public List<Person> getPeopleWithStartingLetter(String startingLetter) throws JpaException {
        try{
            return repository.findByFirstNameStartingWithIgnoreCase(startingLetter);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public List<Person> getPeopleLikeInput(String input) throws JpaException {
        try{
            return repository.findPeopleByFirstNameContainingIgnoreCase(input);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public List<Person> getPeopleByCustomLastNameQuery(String input) throws JpaException {
        try{
            return repository.getPeopleByCustomLastNameQuery(input);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public Person createPerson(Person person) throws JpaException {
        try{
            return repository.save(person);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public Person updatePerson(Person person) throws JpaException {
        try{
            return repository.save(person);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public void deletePerson(long id) throws JpaException {
        try{
            repository.deletePersonById(id);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }
}