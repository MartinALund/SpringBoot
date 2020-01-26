package dk.lundudvikling.springdemo.endpoints.person.repositories;

import dk.lundudvikling.springdemo.endpoints.person.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person getPersonById(long id);

    @Transactional
    void deletePersonById(long id);

}
