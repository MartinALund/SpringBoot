package dk.lundudvikling.springdemo.endpoints.person.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import dk.lundudvikling.springdemo.endpoints.person.models.Person;
import dk.lundudvikling.springdemo.endpoints.person.services.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerImplTest {

    @MockBean
    PersonServiceImpl personService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPersonById() throws Exception {
        Person person = new Person();
        person.setAge(28);
        person.setFirstName("Martin");
        person.setLastName("Lund");
        person.setId(123);
        given(personService.getPerson(123)).willReturn(person);
        mockMvc.perform(get("/people/123"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPeople() throws Exception {
        List<Person> people = new ArrayList<>();
        people.add(new Person());
        people.add(new Person());

        given(personService.getPeople()).willReturn(people);
        mockMvc.perform(get("/people"))
                .andExpect(status().isOk());
    }

    @Test
    public void createPerson() throws Exception {

        Person person = new Person();
        person.setAge(28);
        person.setFirstName("Martin");
        person.setLastName("Lund");
        person.setId(123);
        given(personService.createPerson(person)).willReturn(person);
        mockMvc.perform(post("/people").contentType(APPLICATION_JSON)
                .content(asJsonString(person))).andExpect(status().isCreated());
    }

    @Test
    public void deletePerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/people/{id}", "123")
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
