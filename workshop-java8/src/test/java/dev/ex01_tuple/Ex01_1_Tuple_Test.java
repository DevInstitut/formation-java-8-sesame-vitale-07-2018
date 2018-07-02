package dev.ex01_tuple;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 01.1 : Création d'un Tuple.
 */
public class Ex01_1_Tuple_Test {

    /**
     * Utilisation de la structure tuple 2.
     */
    @Test
    public void test_tuple2() {

        // TODO créer une instance de Tuple2 avec 2 valeurs :
        // - la chaine de caractères "Jean"
        // - l'entier 18
        // Tuple2<???> ??? = ???

        // TODO à partir de l'objet Tuple2, récupérer le nom "Jean"
        String prenom = null;

        // TODO à partir de l'objet Tuple2, récupérer l'age 18
        Integer age = null;


        assertThat(prenom).isEqualTo("Jean");
        assertThat(age).isEqualTo(18);
    }

    /**
     * Utilisation d'un tuple à 3 éléments.
     */
    @Test
    public void test_tuple3() {

        // TODO créer une instance de Tuple3 avec 3 valeurs :
        // - la chaine de caractères "Igor"
        // - l'entier 20
        // - le boolean true
        // Tuple3<???> ??? = ???

        // TODO à partir de l'objet Tuple3, récupérer le nom "Igor"
        String prenom = null;

        // TODO à partir de l'objet Tuple3, récupérer l'age 20
        Integer age = null;


        // TODO à partir de l'objet Tuple3, récupérer le booléen true
        Boolean isManager = null;

        assertThat(prenom).isEqualTo("Jean");
        assertThat(age).isEqualTo(18);
        assertThat(isManager).isEqualTo(true);
    }
}
