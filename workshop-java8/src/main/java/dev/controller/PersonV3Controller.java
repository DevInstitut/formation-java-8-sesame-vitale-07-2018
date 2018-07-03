package dev.controller;

import dev.domain.Person;
import dev.service.ExternalPersonService;
import io.vavr.collection.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class PersonV3Controller {

    private ExternalPersonService personService;

    public PersonV3Controller(ExternalPersonService personService) {
        this.personService = personService;
    }


    public Mono<ServerResponse> listAllPersons(ServerRequest request) {
        return ServerResponse.ok().body( personService.findAll(), Person.class);
    }


}
