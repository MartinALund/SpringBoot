package dk.lundudvikling.springdemo.personService.person.interfaces.services;

import reactor.core.publisher.Mono;

public interface WebClientTestService {

    public String getJsonWebString();
    public Mono<String> getMonoJsonWebString();

}
