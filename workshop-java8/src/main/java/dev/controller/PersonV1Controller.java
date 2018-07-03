package dev.controller;

import dev.domain.Person;
import dev.service.InMemoryPersonService;
import io.vavr.collection.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class PersonV1Controller {

    private InMemoryPersonService inMemoryPersonService;

    public PersonV1Controller(InMemoryPersonService inMemoryPersonService) {
        this.inMemoryPersonService = inMemoryPersonService;
    }

    public Mono<ServerResponse> listAllPersons(ServerRequest request) {
        return ServerResponse.ok().body(
                Mono.just(inMemoryPersonService.findAll()), new ParameterizedTypeReference<List<Person>>() {}
        );
    }

}
