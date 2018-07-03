package dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
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
    public RouterFunction<ServerResponse> routeApp() {

        // la fonction route permet de définir les routes applicatives
        // Chaque route représente le mapping REQUETE <> Réponse
        return route(

                // HTTP GET /hello -> Réponse STATUT OK (code 200), le corps contient le texte "Bonjour".
                GET("/hello"), request -> ServerResponse.ok().body(Mono.just("Bonjour"), String.class)
        );
    }
}
