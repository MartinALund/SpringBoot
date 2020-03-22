package dk.lundudvikling.springdemo.endpoints.person.controllers;

import dk.lundudvikling.springdemo.endpoints.person.interfaces.controllers.WebClientTestController;
import dk.lundudvikling.springdemo.endpoints.person.interfaces.services.WebClientTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebClientTestControllerImpl implements WebClientTestController {

    private WebClientTestService webClientTestService;

    public WebClientTestControllerImpl(WebClientTestService webClientTestService) {
        this.webClientTestService = webClientTestService;
    }

    @Override
    public ResponseEntity<String> getJsonWebString() {
        return new ResponseEntity<>(webClientTestService.getJsonWebString(), HttpStatus.OK);
    }
}
