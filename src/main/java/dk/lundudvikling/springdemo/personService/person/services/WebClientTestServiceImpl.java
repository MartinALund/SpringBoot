package dk.lundudvikling.springdemo.personService.person.services;

import dk.lundudvikling.springdemo.personService.person.interfaces.services.WebClientTestService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientTestServiceImpl implements WebClientTestService {

    private WebClient webClient;
    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    public WebClientTestServiceImpl(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(baseUrl).build();
    }

    @Override
    public String getJsonWebString() {
        return webClient.get()
                .uri("todos/1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public Mono<String> getMonoJsonWebString() {
        return webClient.get()
                .uri("todos/1")
                .retrieve()
                .bodyToMono(String.class);
    }
}
