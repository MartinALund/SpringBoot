package dk.lundudvikling.springdemo.people.interfaces;

import dk.lundudvikling.springdemo.fakes.FakeDataProvider;
import dk.lundudvikling.springdemo.people.interfaces.controllers.PersonController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonControllerTest implements PersonController {

    private FakeDataProvider fakeDataProvider;

    @Before
    public void setup(){
        fakeDataProvider = new FakeDataProvider();
    }

    @Test
    public void should_defaultToHttpStatus501_IfCreatePersonIsNotOverriden(){
        Assert.assertEquals(501, createPerson(fakeDataProvider.getFakePerson()).getStatusCodeValue());
    }

    @Test
    public void should_defaultToHttpStatus501_IfGetPersonByIdIsNotOverriden(){
        Assert.assertEquals(501, getPersonById(123L).getStatusCodeValue());
    }

    @Test
    public void should_defaultToHttpStatus501_IfGetPeopleIsNotOverriden(){
        Assert.assertEquals(501, getPeople().getStatusCodeValue());
    }

    @Test
    public void should_defaultToHttpStatus501_IfUpdatePersonIsNotOverriden(){
        Assert.assertEquals(501, updatePerson(fakeDataProvider.getFakePerson()).getStatusCodeValue());
    }

    @Test
    public void should_defaultToHttpStatus501_IfDeletePersonIsNotOverriden(){
        Assert.assertEquals(501, deletePersonById(123L).getStatusCodeValue());
    }

}
