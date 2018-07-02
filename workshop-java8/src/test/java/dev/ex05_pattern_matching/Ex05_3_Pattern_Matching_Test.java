package dev.ex05_pattern_matching;

import dev.ex03_values.Ex03_2_Try_Test;
import io.vavr.Function0;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import static io.vavr.API.*;
import static io.vavr.Predicates.*;
import static io.vavr.Patterns.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 05.3 : Pattern Matching (exemple de capture des erreurs)
 */
public class Ex05_3_Pattern_Matching_Test {

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

    Try<String> concatNameAge(String name, Integer age) {
        return Try.of(
                () -> {
                    if (age <= 18) {
                        throw new AgeException();
                    }

                    if(name.length() < 2) {
                        throw new NameException();
                    }
                    return name + "(" + age + ")";
                }
        );
    }


    String processConcat(String name, Integer age) {
        Try<String> result = concatNameAge(name, age);

        // Utilisation du Pattern Matching pour gérer les cas d'erreurs.
        return Match(result).of(
                Case($Failure($(instanceOf(AgeException.class))), "invalid age"),
                Case($Failure($(instanceOf(NameException.class))), "invalid name"),
                Case($Success($(instanceOf(String.class))), i -> i)
        );

    }

    @Test
    public void test_invalid_name() {
        String result = processConcat("J", 90);

        assertThat(result).isEqualTo("invalid name");
    }


    @Test
    public void test_invalid_age() {
        String result = processConcat("Jean", 12);

        assertThat(result).isEqualTo("invalid age");
    }


    @Test
    public void test_valid() {
        String result = processConcat("Jean", 20);

        assertThat(result).isEqualTo("Jean(20)");
    }
}
