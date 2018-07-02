package dev.ex05_pattern_matching;

import dev.ex04_collections.Ex04_List_Test;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import java.util.function.Predicate;

import static io.vavr.API.*;
import static io.vavr.Predicates.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Exercice 05.2 : Pattern Matching.
 */
public class Ex05_2_Pattern_Matching_Test {

    class Person {

        final String name;
        final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    List<Person> people =  List.of(
                new Person("Rebel", 17),
                new Person("Jean", 40)
    );


    // TODO A l'aide du pattern matching, transformer objet suivant les règles suivantes :
    // - Si l'objet est une instance de String alors elle est transformer en majuscule
    // - Si l'objet est une instance de personne alors le nom de la personne en majuscule est retourné
    // - Sinon lancement d'une exception throw new IllegalArgumentException("unknown string");
    // Utiliser la structure Try pour éviter la rupture du flux d'exécution.
    Try<String> toUpperCase(Object entry) {
        return null;
    }


    /**
     * Cas String.
     */
    @Test
    public void test_match_string() {

        String validStr = "jean";

        Try<String> result = toUpperCase(validStr);
        assertThat(result).contains("JEAN");
    }

    /**
     * Cas Person.
     */
    @Test
    public void test_match_person() {

        Person validPerson = new Person("Rebel", 10);

        Try<String> result = toUpperCase(validPerson);
        assertThat(result).contains("REBEL");
    }
}
