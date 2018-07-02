package dev.ex03_values;

import io.vavr.MatchError;
import io.vavr.control.Try;
import org.junit.Test;

import java.util.IllegalFormatException;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;
import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 03.2 : Try.
 */
public class Ex03_2_Try_Test {

    // Soit 2 exceptions

    class AgeException extends Exception {
        public AgeException() {
            super("invalid age");
        }
    }
    class NameException extends Exception {
        public NameException() {
            super("Invalid name");
        }
    }

    // Soit une méthode qui retourne une concaténation d'un nom et de l'âge.
    // Elle déclenche des exceptions.
    private String concatNameAge(String name, Integer age) throws AgeException, NameException {
        if (age <= 18) {
            throw new AgeException();
        }

        if(name.length() < 2) {
            throw new NameException();
        }
        return name + "(" + age + ")";
    }

    /**
     * Cas d'erreur sur l'age.
     */
    @Test
    public void test_failure_age() {

        // Soit un nom et un age invalide
        String name = "Jean";
        Integer ageMineur = 10;

        // TODO A l'aide de la méthode Try.of, invoquer la méthode concatNameAge avec name et ageMineur
        // ??? result = ???
        Try<String> result = Try.of(() -> concatNameAge(name, ageMineur));

        // TODO invoquer la méthode isFailure sur result
        Boolean isFailure = result.isFailure();

        // TODO invoquer la méthode getCause sur result
        Throwable cause = result.getCause();

        assertThat(isFailure).isTrue();
        assertThat(cause).isInstanceOf(AgeException.class);

    }

    /**
     * Cas de succès.
     */
    @Test
    public void test_success() {
        // Soit un nom et un age valide
        String name = "Jean";
        Integer ageMajeur = 40;

        // TODO A l'aide de la méthode Try.of, invoquer la méthode concatNameAge avec name et ageMajeur
        // ??? result = ???
        Try<String> result = Try.of(() -> concatNameAge(name, ageMajeur));

        // TODO invoquer la méthode isFailure sur result
        Boolean isFailure = result.isFailure();


        // TODO invoquer la méthode isSuccess sur result
        Boolean isSuccess = result.isSuccess();

        // TODO récupérer le résultat à l'aide de la méthode get
        String value = result.get();

        assertThat(isFailure).isFalse();
        assertThat(isSuccess).isTrue();
        assertThat(value).isEqualTo("Jean(40)");
    }
}
