package dev.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Random;

/**
 * Service de génération d'un flux infini de température.
 */
@Service
public class TemperatureGenService {

    // Fréquence en nano-seconde
    // Ici toutes les 5 secondes
    private static final long RATE_NANO = 1_000_000_000L;

    private Flux<Long> temperatureFlux;

    @PostConstruct
    public void init() {

        // Flux d'entier aléatoire entre -10 et 45
        Flux<Long> randomIntFlux = Flux.fromStream(new Random().ints(-10, 45).boxed())
                .map(Long::valueOf);


        // Création d'un flux partagé qui émet une valeur de température à la fréquence définie par RATE_NANO
        this.temperatureFlux =  Flux.interval(Duration.ofNanos(RATE_NANO))
                .zipWith(randomIntFlux, (tick, temperature) -> temperature)
                .share();
    }

    public Flux<Long> getTemperatureStream() {
        return this.temperatureFlux;
    }
}
