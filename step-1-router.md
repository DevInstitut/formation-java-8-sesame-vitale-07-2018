# Atelier Programmation Fonctionnelle avec Java 8, Vavr & Spring WebFlux

## Etape 1 - Le routeur

Nous allons travailler dans ce TP dans la classe `dev.Router`.

* Ajouter les imports statiques utiles pour définir un routeur :

```java

// imports statiques à ajouter
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
```

## GET /hello

* Définir une route :

```java

@Bean
public RouterFunction<ServerResponse> routeApp() {

    // la fonction route permet de définir les routes applicatives
    // Chaque route représente le mapping REQUETE <> Réponse
    return route (
           // HTTP GET /hello -> Réponse STATUT OK (code 200), le corps contient le texte "Bonjour".
            GET("/hello"), request -> ServerResponse.ok().body(Mono.just("Bonjour"), String.class)
    );
}
```

* Démarrer l'application via la classe `dev.App`.

* Tester l'url : `http://localhost:8080/hello`.

## GET /v0/persons

* Ajouter une route :

```java

@Bean
public RouterFunction<ServerResponse> routeApp() {

    // la fonction route permet de définir les routes applicatives
    // Chaque route représente le mapping REQUETE <> Réponse
    return route (
           // HTTP GET /hello -> Réponse STATUT OK (code 200), le corps contient le texte "Bonjour".
            GET("/hello"), request -> ServerResponse.ok().body(Mono.just("Bonjour"), String.class)
    )
    .andRoute(
        GET("/v0/persons"), this::findAllPersons
    );
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
```

* Redémarrer l'application via la classe `dev.App`.

* Tester l'url : `http://localhost:8080/v0/persons`.


## GET /v1/persons

* Créer un service `dev.service.InMemoryPersonService`

```java

package dev.service;

import dev.domain.Person;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

/**
 * Jeux de données personnes en mémoire.
 */
@Service
public class InMemoryPersonService {

    public List<Person> findAll() {
        return List.of(
                new Person("jo@dev.dr", "Jean", "OLAC", 10),
                new Person("ro@dev.dr", "Richie", "OLAC", 20),
                new Person("jl@dev.dr", "Jean", "LEDUC", 30),
                new Person("jd@dev.dr", "Jeanne", "LADEV", 40),
                new Person("hm@dev.dr", "Hélène", "Master", 50)
        );
    }
}
```

* Créer un contrôleur `dev.controller.PersonV1Controller`.

```java
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

    public Mono<ServerResponse> listAllPersons(ServerRequest request) {
        // TODO retourner une réponse OK avec la liste des personnes du service InMemoryPersonService. 
        // Utiliser l'injection de dépendance ça reste du Spring...
        return null;
    }
}
```

* Compléter le routeur pour que les requêtes `GET /v1/persons` soit traitées par `PersonV1Controller.listAllPersons`.
