package dev.controller;

import dev.domain.Person;
import dev.repository.PersonJpaRepository;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class PersonV2Controller {

    private PersonJpaRepository personJpaRepository;

    public PersonV2Controller(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    public Mono<ServerResponse> listAllPersons(ServerRequest request) {
        return personJpaRepository.findAll()
                .transform(list -> Mono.just(list))
                .transform(monoList -> ServerResponse.ok().body(monoList, new ParameterizedTypeReference<List<Person>>(){}));
    }

    public Mono<ServerResponse> findOnePerson(ServerRequest request) {
       return Try.of(() -> Long.valueOf(request.pathVariable("id")))
                .map(id -> personJpaRepository.findById(id))
                .map(
                        optPerson -> optPerson.map(p -> Mono.just(p))
                                                .map(monoPerson -> ServerResponse.ok().body(monoPerson, Person.class))
                                                .getOrElse(() -> ServerResponse.badRequest().body(Mono.just("personne non trouvée"), String.class)))
        .getOrElse(() -> ServerResponse.badRequest().body(Mono.just("format id incorrect"), String.class));
    }
}
