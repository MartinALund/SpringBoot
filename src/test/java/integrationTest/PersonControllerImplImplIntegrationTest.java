package integrationTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import dk.lundudvikling.springdemo.personService.person.implementations.controllers.PersonControllerImpl;
import dk.lundudvikling.springdemo.personService.person.models.Person;
import dk.lundudvikling.springdemo.personService.person.implementations.services.PersonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonControllerImpl.class)
public class PersonControllerImplImplIntegrationTest {

    //Mock your service here
    @MockBean
    PersonServiceImpl personService;
    @Autowired
    private MockMvc mockMvc;

    //Create mock object here
    private Person person;

    //Set your endpoint base path here
    private final String BASE_PATH = "/people/";

    @Before
    public void setup(){
        setupTestPerson();
    }

    public void setupTestPerson(){
        person = new Person();
        person.setAge(28);
        person.setFirstName("Martin");
        person.setLastName("Lund");
        person.setId(123);
    }

    @Test
    public void getPersonById() throws Exception {
        int id = 123;
        given(personService.getPerson(123)).willReturn(person);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get(BASE_PATH + id))
                .andExpect(status().isOk())
                .andReturn();

        String name = JsonPath.read(result.getResponse().getContentAsString(), "$.firstName");


        Assert.assertEquals("Martin", name);
    }

    @Test
    public void getPeople() throws Exception {
        List<Person> people = new ArrayList<>();
        people.add(person);
        given(personService.getPeople())
                .willReturn(people);

        mockMvc.perform(
                MockMvcRequestBuilders.get(BASE_PATH))
                .andExpect(status().isOk());
    }

    @Test
    public void createPerson() throws Exception {
        given(personService.createPerson(person)).willReturn(person);
        mockMvc.perform(
                MockMvcRequestBuilders.post(BASE_PATH)
                        .contentType(APPLICATION_JSON)
                .content(asJsonString(person))).andExpect(status().isCreated());
    }

    @Test
    public void deletePerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete(BASE_PATH + "/{id}", "123")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
