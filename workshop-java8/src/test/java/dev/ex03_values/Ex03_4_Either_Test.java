package dev.ex03_values;

import io.vavr.control.Either;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 03.4 : Either.
 */
public class Ex03_4_Either_Test {

    // Soit une méthode de division

    double diviserWithException(Double x, Double y) {
        if(y == 0) {
            throw new IllegalArgumentException("Division par 0 interdite.");
        }
        return x / y;
    }

    // TODO Compléter la méthode pour implémenter une division
    // - String représente le message d'erreur "Division par 0 interdite."
    // - Double représente le résultat
    Either<String, Double> diviser(Double x, Double y) {
        // TODO
        return null;
    }

    /**
     * Cas du message.
     */
    @Test
    public void test_left() {

        Either<String, Double> result = diviser(10.0, 0.0);

        assertThat(result.isLeft()).isTrue();
        assertThat(result.isRight()).isFalse();
        assertThat(result.getLeft()).isEqualTo("Division par 0 interdite.");
    }

    /**
     * Cas du résultat.
     */
    @Test
    public void test_right() {

        Either<String, Double> result = diviser(10.0, 2.0);

        assertThat(result.isLeft()).isFalse();
        assertThat(result.isRight()).isTrue();
        assertThat(result.get()).isEqualTo(5.0);
    }

    /**
     * Exemple de transformation du résultat.
     */
    @Test
    public void test_right_map() {

        Either<String, Double> result = diviser(10.0, 2.0);

        Either<String, Double> mapResult = result.right().map(
                nb -> nb + 10
        ).toEither();


        assertThat(mapResult.isRight()).isTrue();
        assertThat(mapResult.get()).isEqualTo(15);

    }

    /**
     * Exemple de transformation de l'erreur.
     */
    @Test
    public void test_left_map() {

        Either<String, Double> result = diviser(10.0, 0.0);

        Either<String, Double> mapResult = result.left().map(
                error -> "Error[" + error + "]"
        ).toEither();


        assertThat(mapResult.isLeft()).isTrue();
        assertThat(mapResult.getLeft()).isEqualTo("Error[Division par 0 interdite.]");

    }


}
