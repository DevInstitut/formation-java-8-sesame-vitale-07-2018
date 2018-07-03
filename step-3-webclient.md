# Atelier Programmation Fonctionnelle avec Java 8, Vavr & Spring WebFlux

## Etape WebClient

Deux services sont actuellement publiés sur le web :

* Service 1 : https://c1.cleverapps.io/collegues

* Service 2 : https://c2.cleverapps.io/collegues


Ils permettent de récupérer 2 jeux de données d'entités Collègue.

Dans ce TP, nous souhaitons :

* Récupérer les données des deux services, les transformer en objet `Person` puis les exposer via le web.

### Services d'accès aux collègues


* Créer la classe `dev.service.colleagues. WSColleague` 

```java
package dev.service.colleagues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WSColleague {

    private String matricule;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String nom;
    private String prenom;
    private String dateNaissance;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
```

* Créer le service `dev.service.colleagues.WSColleagueService1`.

```java
package dev.service.colleagues;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class WSColleagueService1 {

    public static final String BASE_URL = "https://c1.cleverapps.io/collegues";
    private final WebClient webClient;

    public WSColleagueService1(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public Flux<WSColleague> findAll() {
        return  this.webClient.get()
                .retrieve()
                .bodyToFlux(WSColleague.class)
                .share();

    }
}

```

* Créer le service `dev.service.colleagues.WSColleagueService2`.

```java
package dev.service.colleagues;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class WSColleagueService2 {

    public static final String BASE_URL = "https://c2.cleverapps.io/collegues";
    private final WebClient webClient;

    public WSColleagueService2(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }
    
    public Flux<WSColleague> findAll() {
        return  this.webClient.get()
                .retrieve()
                .bodyToFlux(WSColleague.class)
                .share();
    }
}
```

### Service de transformation Collègue -> Personne

* Créer un service `dev.service.ExternalPersonService` :

```java
package dev.service;

import dev.domain.Person;
import dev.service.colleagues.WSColleagueService1;
import dev.service.colleagues.WSColleagueService2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ExternalPersonService {

    private final WSColleagueService1 wsColleagueService1;
    private final WSColleagueService2 wsColleagueService2;

    public ExternalPersonService(WSColleagueService1 wsColleagueService1, WSColleagueService2 wsColleagueService2) {
        this.wsColleagueService1 = wsColleagueService1;
        this.wsColleagueService2 = wsColleagueService2;
    }

    public Flux<Person> findAll() { 
        
        // TODO Récupérer les flux des services WSColleagueService1 et WSColleagueService2
        // TODO Concaténer les flux via l'opérateur concatWith (exemple flux1.concatWith(flux2))
        // TODO Transformer ensuite le flux de WSColleague en flux de Person
        // - nom -> lastname
        // - prenom -> firstname;
        // - email -> email;
        // - dateNaissance -> age (calcul par rapport à la date du jour);
        
    }
}
```

### GET /v3/persons

```java
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

    public Mono<ServerResponse> listAllPersons(ServerRequest request) {
        // TODO
        return null;
    }


}

```

* Compléter l'application pour la requête `GET /v3/persons` affiche la liste des personnes issues des collègues au format JSON.
