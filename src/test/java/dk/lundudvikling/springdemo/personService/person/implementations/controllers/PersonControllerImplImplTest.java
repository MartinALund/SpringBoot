package dk.lundudvikling.springdemo.personService.person.implementations.controllers;

import dk.lundudvikling.springdemo.personService.person.models.Person;
import dk.lundudvikling.springdemo.personService.person.implementations.services.PersonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonControllerImplImplTest {

    private PersonControllerImpl personControllerImpl;

    @MockBean
    private PersonServiceImpl personService;

    private List<Person> fakePeople;
    private Person fakePerson;

    @Before
    public void setup(){
        personControllerImpl = new PersonControllerImpl(personService);
        fakePerson = fakePerson();
        fakePeople = fakePeopleData();
    }

    private List<Person> fakePeopleData(){
        List<Person> people = new ArrayList<>();
        people.add(fakePerson());
        return people;
    }

    private Person fakePerson(){
        return new Person("Martin", "Lund", 29);
    }

    @Test
    public void testGetPeople_SunshineScenario(){
        when(personService.getPeople()).thenReturn(fakePeople);
        Assert.assertEquals(200, personControllerImpl.getPeople().getStatusCodeValue() );
    }

    @Test
    public void testGetPersonById_SunshineScenario(){
        when(personService.getPerson(any(Integer.class))).thenReturn(new Person("Martin", "Lund", 29));
        Assert.assertEquals(200, personControllerImpl.getPersonById(10).getStatusCodeValue());
    }

    @Test
    public void testCreatePerson_SunshineScenario(){
        when(personService.createPerson(fakePerson)).thenReturn(fakePerson);
        Assert.assertEquals(201, personControllerImpl.createPerson(fakePerson).getStatusCodeValue());
    }

    @Test
    public void testDeletePerson_SunshineScenario(){
        Assert.assertEquals(204, personControllerImpl.deletePersonById(10).getStatusCodeValue());
        verify(personService).deletePerson(10);
    }

    @Test
    public void testUpdatePerson_SunshineScenario(){
        String expectedLastName = "Lunde";
        when(personService.updatePerson(fakePerson)).thenReturn(new Person("Martin", "Lunde", 29));
        Person person = personControllerImpl.updatePerson(fakePerson).getBody();
        personControllerImpl.updatePerson(fakePerson).getStatusCodeValue();
        Assert.assertEquals(200, personControllerImpl.updatePerson(fakePerson).getStatusCodeValue());
        Assert.assertEquals(expectedLastName, person.getLastName());
    }

}
