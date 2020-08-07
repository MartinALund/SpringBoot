package dk.lundudvikling.springdemo.people.implementations.controllers;

import dk.lundudvikling.springdemo.fakes.FakeDataProvider;
import dk.lundudvikling.springdemo.people.implementations.services.PersonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PersonControllerImplTest {

    PersonControllerImpl systemUnderTest;
    @MockBean
    PersonServiceImpl mockedService;
    FakeDataProvider fakeDataProvider;

    @Before
    public void setup(){
        systemUnderTest = new PersonControllerImpl(mockedService);
        fakeDataProvider = new FakeDataProvider();
    }

    @Test
    public void should_returnHttpStatus200_whenGetPeopleIsCalled(){
        when(mockedService.getPeople()).thenReturn(fakeDataProvider.getFakePeople());
        Assert.assertEquals(200, systemUnderTest.getPeople().getStatusCodeValue());
    }
    
}
