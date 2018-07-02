package dev.ex05_pattern_matching;

import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;
import static io.vavr.API.*;

import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 05.1 : Pattern Matching.
 */
public class Ex05_1_Pattern_Matching_Test {

    // Soit une liste de 3 chaînes de caractères.
    List<String> strings = List.of("un", "deux", "trois");


    // TODO A l'aide du pattern matching, transformer une chaîne de caractères suivant les règles suivantes :
    // - Si "un" alors 1
    // - Si "deux" alors 2
    // - Si "trois" alors 3
    // - Sinon lancement d'une exception throw new IllegalArgumentException("unknown string");
    // Utiliser la structure Try pour éviter la rupture du flux d'exécution.
    Try<Integer> stringToInt(String entry) {
        return null;
    }

    /**
     * Cas valide.
     */
    @Test
    public void test_match_valid() {

        String validStr = "un";

        Try<Integer> un = stringToInt(validStr);
        assertThat(un).contains(1);
    }

    /**
     * Cas d'une chaîne inconnue.
     */
    @Test
    public void test_match_invalid() {

        String validStr = "quatre";

        Try<Integer> un = stringToInt(validStr);
        assertThat(un.isFailure()).isTrue();
        assertThat(un.getCause()).isInstanceOf(IllegalArgumentException.class);
    }
}
