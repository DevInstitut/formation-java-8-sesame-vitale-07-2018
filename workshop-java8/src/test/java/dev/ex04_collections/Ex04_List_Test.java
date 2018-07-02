package dev.ex04_collections;

import io.vavr.collection.List;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 04 : List.
 */
public class Ex04_List_Test {

    class Person {

        final String name;
        final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    io.vavr.collection.List<Person> findPeople() {

        // TODO Créer une liste de personnes à l'aide de List.of

        /*

                new Person("Rebel", 17),
                new Person("Jean", 40),
                new Person("Hugues", 42),
                new Person("Lisa", 40)

         */

        return null;

    }

    /**
     * Validation du contenu de la liste.
     */
    @Test
    public void test_new_list() {

        List<Person> people = findPeople();

        assertThat(people).extracting(p -> p.name).contains("Rebel", "Jean", "Hugues", "Lisa");
    }

    /**
     * Exemple de filtre.
     */
    @Test
    public void test_filter() {
        List<Person> people = findPeople();

        // TODO filtrer les personnes pour ne garder que les adultes age >= 18
        List<Person> result = null;

        assertThat(result).extracting(p -> p.name).doesNotContain("Rebel");
    }

    /**
     * Exemple de groupement.
     */
    @Test
    public void test_map() {
        List<Person> people = findPeople();

        // TODO grouper les personnes par age
        Map<Integer, List<Person>> groupByAge = null;

        assertThat(groupByAge.get(17).isEmpty()).isFalse();
        assertThat(groupByAge.get(41).isEmpty()).isTrue();
        assertThat(groupByAge.get(40).get().size()).isEqualTo(2);
    }


}
