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
