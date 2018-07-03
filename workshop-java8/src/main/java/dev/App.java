package dev;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Lancement de l'application.
 */
@SpringBootApplication
public class App {

    @Bean
    public ObjectMapper jacksonBuilder() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new VavrModule());
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
