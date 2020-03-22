package dk.lundudvikling.springdemo.endpoints.person.interfaces.services;

import reactor.core.publisher.Mono;

public interface WebClientTestService {

    public String getJsonWebString();
    public Mono<String> getMonoJsonWebString();

}
