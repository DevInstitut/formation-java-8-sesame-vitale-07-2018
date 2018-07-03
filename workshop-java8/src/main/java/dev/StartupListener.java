package dev;

import dev.domain.Person;
import dev.repository.PersonJpaRepository;
import io.vavr.collection.List;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener {

    private PersonJpaRepository personRepository;

    public StartupListener(PersonJpaRepository personRepository) {
        this.personRepository = personRepository;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void initialize() {

        List.of(
                new Person("jo@bdd.fr", "Jean", "OLAC", 10),
                new Person("ro@bdd.dr", "Richie", "OLAC", 10),
                new Person("jl@bdd.dr", "Jean", "LEDUC", 10),
                new Person("jd@bdd.dr", "Jeanne", "LADEV", 10),
                new Person("hm@bdd.dr", "Hélène", "Master", 10)
        ).forEach(personRepository::save);
    }
}
