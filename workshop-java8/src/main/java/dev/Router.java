package dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Routeur applicatif.
 * Il s'agit des points d'entrée des requêtes HTTP.
 */
@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> routeApp() {

        // TODO définir des routes
        return null;
    }
}
