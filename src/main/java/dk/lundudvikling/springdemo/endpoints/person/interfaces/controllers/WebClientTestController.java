package dk.lundudvikling.springdemo.endpoints.person.interfaces.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("webclient")
public interface WebClientTestController {

    @GetMapping()
    default ResponseEntity<String> getJsonWebString(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
