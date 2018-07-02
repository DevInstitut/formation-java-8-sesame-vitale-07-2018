package dev.ex01_tuple;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.Tuple4;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Exercice 01.2 : Transformer un tuple.
 */
public class Ex01_2_Tuple_Test {


    /**
     * Transformer un Tuple via la méthode "map".
     */
    @Test
    public void test_map_plusieurs_parametres() {

        // Soit un tuple <prenom, nom, annee>
        // - le prénom et le nom sont tous les deux en minuscule
        // - l'année de naissance est exprimé sur 2 chiffres : exemple 50 pour 1950, 10 pour 2010
        Tuple3<String, String, Integer> t1 = Tuple.of("igor", "ledev", 50);

        // Nous souhaitons opérer les transformations suivantes :
        // - le prénom doit avoir sa première lettre en majuscule (utilitaire org.apache.commons.lang3.StringUtils)
        // - le nom doit avoir toutes les lettres en majuscule
        // - l'année doit être exprimé sur 4 chiffres, ajouter 1900.
        // TODO A l'aide de l'opérateur "map" (version 3 paramètres), réaliser la transformation souhaitée.
        Tuple3<String, String, Integer> result = null;

        assertThat(result._1).isEqualTo("Igor");
        assertThat(result._2).isEqualTo("LEDEV");
        assertThat(result._3).isEqualTo(1950);

    }

    // Soit une classe Person
    class Person {
        String firstame;
        Integer age;

        public Person(String firstame,  Integer age) {
            this.firstame = firstame;
            this.age = age;
        }
    }

    /**
     * Transformer un Tuple en un autre type.
     */
    @Test
    public void test_apply() {

        // Soit un tuple <prenom, age>
        Tuple2<String, Integer> prenomAge = Tuple.of("Alex", 30);

        // TODO utiliser la méthode apply pour transformer prenomAge en Person
        Person result = null;

        assertThat(result.firstame).isEqualTo("Alex");
        assertThat(result.age).isEqualTo(30);
    }
}
