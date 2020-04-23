package dk.lundudvikling.springdemo.endpoints.person.services;

import dk.lundudvikling.springdemo.endpoints.person.interfaces.services.PersonService;
import dk.lundudvikling.springdemo.endpoints.person.models.Person;
import dk.lundudvikling.springdemo.endpoints.person.repositories.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {

    private PersonService personService;
    @MockBean private PersonRepository repository;

    private Person mockPerson;
    private List<Person> peopleList;

    @Before
    public void setup(){
        personService = new PersonServiceImpl(repository);
        peopleList = new ArrayList<>();
        setupMockPerson();
        peopleList.add(mockPerson);
    }

    @Test
    public void testGetPersonSunshineScenario(){
        String expectedName = "Martin";

        Mockito.when(repository.getPersonById(any(Long.class))).thenReturn(mockPerson);

        Person person = personService.getPerson(123L);
        Assert.assertEquals(expectedName, person.getFirstName());
    }

    @Test
    public void testDeletePersonSunshineScenario(){
        personService.deletePerson(1234L);
        verify(repository, times(1)).deletePersonById(any(Long.class));
    }

    @Test
    public void testPutPersonSunshineScenario(){
        String expectedName = "Updated";
        int expectedId = 1234;
        Person personUpdate = mockPerson;
        personUpdate.setFirstName("Updated");
        personUpdate.setLastName("Person");
        personUpdate.setAge(1);
        Mockito.when(repository.save(any(Person.class))).thenReturn(personUpdate);
        Person person = personService.updatePerson(mockPerson);
        Assert.assertEquals(expectedName, person.getFirstName());
        Assert.assertEquals(expectedId, person.getId());
    }

    @Test
    public void testCreatePersonSunshineScenario(){
        String expectedName = "Martin";
        int expectedId = 1234;
        Mockito.when(repository.save(any(Person.class))).thenReturn(mockPerson);
        Person person = personService.updatePerson(mockPerson);
        Assert.assertEquals(expectedName, person.getFirstName());
        Assert.assertEquals(expectedId, person.getId());
    }

    public void setupMockPerson(){
        mockPerson = new Person();
        mockPerson.setId(1234);
        mockPerson.setAge(28);
        mockPerson.setFirstName("Martin");
        mockPerson.setLastName("Lund");
    }
}
