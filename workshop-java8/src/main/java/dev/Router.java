package dev;

import dev.controller.PersonV1Controller;
import dev.controller.PersonV2Controller;
import dev.controller.PersonV3Controller;
import dev.domain.Person;
import io.vavr.collection.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * Routeur applicatif.
 * Il s'agit des points d'entrée des requêtes HTTP.
 */
@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> routeApp(PersonV1Controller personV1Controller, PersonV2Controller personV2Controller, PersonV3Controller personV3Controller) {

        // la fonction route permet de définir les routes applicatives
        // Chaque route représente le mapping REQUETE <> Réponse
        return route (
                // HTTP GET /hello -> Réponse STATUT OK (code 200), le corps contient le texte "Bonjour".
                GET("/hello"), request -> ServerResponse.ok().body(Mono.just("Bonjour"), String.class)
        )
        .andRoute(
                GET("/v0/persons"), this::findAllPersons
        )
        .andRoute(
                GET("/v1/persons"), personV1Controller::listAllPersons
        )

        .andRoute(
                GET("/v2/persons"), personV2Controller::listAllPersons
        )
        .andRoute(
                GET("/v2/persons/{id}"), personV2Controller::findOnePerson
        )
        .andRoute(
                GET("/v3/persons"), personV3Controller::listAllPersons
        )
        ;
}

    public Mono<ServerResponse> findAllPersons(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just(List.of(
                new Person("jo@dev.dr", "Jean", "OLAC", 10),
                new Person("ro@dev.dr", "Richie", "OLAC", 10),
                new Person("jl@dev.dr", "Jean", "LEDUC", 10),
                new Person("jd@dev.dr", "Jeanne", "LADEV", 10),
                new Person("hm@dev.dr", "Hélène", "Master", 10)
        )), new ParameterizedTypeReference<List<Person>>(){});
    }
}
