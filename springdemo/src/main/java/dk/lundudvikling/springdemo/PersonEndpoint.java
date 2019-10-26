package dk.lundudvikling.springdemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonEndpoint {
    private static List<Person> people;
    public PersonEndpoint() {
        people = new ArrayList<>();
        people.add(new Person("Martin", 1, "Test"));
        people.add(new Person("Test", 2, "Martin test person bruger 2"));
    }
    @GetMapping
    public List<Person> getPerson(){
        return people;
    }

    @GetMapping("/{id}")
    public Person getPersonFromId(@PathVariable("id") int id){

        for (Person person : people){
            if (person.getId() == id){
                return person;
            }
        }
        return null;
    }
    @DeleteMapping("/{id}")
        public String deletePersonFromId(@PathVariable("id") int id){
        for (Person person : people){
            if (person.getId() == id){
                people.remove(person);
                return "Removed person";
            }
        }
            return "Could not find person";
        }
    @PostMapping
    public String addPersonToList(@RequestBody Person person){
        people.add(person);
        return "";
    }
}


class Person{
    private String name;
    private int id;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person() {
    }

    public Person(String name, int id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }
}

