package dev.ex02_functions;

import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.control.Option;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  Exercice 02 : Fonctions Vavr.
 */
public class Ex02_Functions_Test {

    /**
     * Création d'une fonction à 3 paramètres.
     */
    @Test
    public void test_create_function() {

        // TODO Créer une fonction identite
        // - Paramètres d'entrées :
        //       * nom (String)
        //       * prenom (String)
        //       * age (Integer)
        // - Type retour = String
        //       * format NOM Prénom (age ans)
        // ??? identite = ???;

        // Soit 3 paramètres
        String nom = "Igor";
        String prenom = "Jean";
        Integer age = 45;

        // TODO invoquer la fonction identite
        String result = null;

        assertThat(result).isEqualTo("IGOR Jean (45 ans)");
    }

    /**
     * Les fonctions Vavr sont composables.
     */
    @Test
    public void test_composition() {

        // Soit une fonction toUppercase
        Function1<String, String> toUppercase = name -> name.toUpperCase();

        // Soit une fonction addBracket
        Function1<String, String> addBracket = name -> "(" + name + ")";


        // TODO Créer une fonction qui enchaîne les transformations toUpperCase et addBracket
        Function1<String, String> toUpperCaseAndAddBracket = null;

        String uneStr = "formation java 8";

        // TODO Invoquer la fonction toUpperCaseAndAddBracket avec en paramètre uneStr
        String result = null;

        assertThat(result).isEqualTo("(FORMATION JAVA 8)");

    }


    /**
     * Soit une méthode qui crée une chaîne de caractères à partir d'un nom et d'un age.
     *
     * Cette méthode déclenche une exception si l'age est < 18.
     */
    private String concatNameAge(String name, Integer age) {
        if (age < 18) {
            throw new IllegalArgumentException("seuls les adultes méritent une concaténation");
        }
        return name + "(" + age + ")";
    }

    /**
     * Notion de "Lifting" d'une fonction.
     */
    @Test
    public void test_lifting() {
        // TODO Créer une variable qui référence la méthode concatNameAge
        // ??? concatNameAge = ???;

        // TODO Utiliser la fonction statique lift pour créer une version de la fonction concatNameAge robuste aux exceptions
        // ??? concatNameAgeLifted = ???

        // Soit un nom
        String name = "John";
        Integer age1 = 10;

        // TODO Invoquer la fonction concatNameAgeLifted avec name et age1
        Option<String> result1 = null;

        // Dans ce cas, age < 18, alors l'exception devrait être déclenchée.
        // Ce qui ne sera pas le cas de notre fonction liftée.
        assertThat(result1.isDefined()).isFalse();

        Integer age2 = 20;


        // TODO Invoquer la fonction concatNameAgeLifted avec name et age2
        Option<String> result2 = null;

        // Dans ce cas, age >= 18.
        // Le résultat est défini.
        assertThat(result2.isDefined()).isTrue();


    }

    /**
     * Notion d'application partielle.
     */
    @Test
    public void test_partial_application() {

        // Soit une fonction multiplyAndAdd
        Function3<Integer, Integer, Integer, Integer> multiplyAndAdd = (x1, x2, x3) -> (x1 * x2) + x3;

        // TODO Créer une fonction multiply10AndAdd à partir de la fonction multiplyAndAdd
        // - Utiliser l'exécution partielle ppur valoriser x1 = 10
        // ??? multiply10AndAdd = ???;

        // TODO invoquer la fonction multiply10AndAdd avec x2 = 2 et x3 = 3
        Integer result1 = null;

        assertThat(result1).isEqualTo(23);

        // TODO invoquer la fonction multiply10AndAdd avec x2 = 3 et x3 = 2
        Integer result2 = null;

        assertThat(result2).isEqualTo(32);
    }

    /**
     * Notion de Currying.
     */
    @Test
    public void test_currying() {
        // Soit la fonction multiplyAndAdd
        Function3<Integer, Integer, Integer, Integer> multiplyAndAdd = (x1, x2, x3) -> (x1 * x2) + x3;

        // TODO Créer une fonction multiply10AndAdd à partir de la fonction multiplyAndAdd
        // - Utiliser l'exécution partielle ppur valoriser x1 = 10
        // - Utiliser le Currying en invoquant multiplyAndAdd.curried()
        // ??? multiply10AndAdd = ???;

        // TODO invoquer la fonction multiply10AndAdd avec x2 = 2 et x3 = 3
        Integer result1 = null;

        assertThat(result1).isEqualTo(23);

        // TODO invoquer la fonction multiply10AndAdd avec x2 = 3 et x3 = 2
        Integer result2 = null;

        assertThat(result2).isEqualTo(32);
    }

    /**
     * Memoization.
     */
    @Test
    public void test_memoization() {

        // Soit une fonction de génération d'un nombre
        Function0<Double> random = Function0.of(Math::random);


        Double r1 = random.apply();
        Double r2 = random.apply();

        // Vérification que les 2 nombres sont différents
        assertThat(r1).isNotEqualTo(r2);

        // TODO Appliquer la méthode memoized à la fonction random
        // ??? randomCached = ???;

        // TODO invoquer la méthode randomCached
        Double r3 = null;

        // TODO invoquer la méthode randomCached
        Double r4 = null;

        // Vérification que les 2 nombres sont les mêmes
        // Le résultat de l'exécution est mise en cache
        assertThat(r3).isEqualTo(r4);
    }
}
