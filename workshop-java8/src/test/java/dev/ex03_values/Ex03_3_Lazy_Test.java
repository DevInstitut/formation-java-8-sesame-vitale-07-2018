package dev.ex03_values;

import io.vavr.Lazy;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 03.3 : Lazy.
 */
public class Ex03_3_Lazy_Test {

    /**
     * Évaluation tardive d'une valeur.
     */
    @Test
    public void test_lazy() {

        // Soit une valeur chargée tardivement
        Lazy<String> result = Lazy.of(() -> "Super valeur");

        // A ce stade l'expression n'est pas encore évaluée.
        assertThat(result.isEvaluated()).isFalse();

        // TODO utiliser la méthode get() sur result
        String value = result.get();

        // A ce stade l'expression est évaluée.
        assertThat(result.isEvaluated()).isTrue();

        // validation de la valeur
        assertThat(value).isEqualTo("Super valeur");

    }

    // Illustrons à présent ce chargement tardif sur une structure.

    // Créons un flag qui va nous aider à déterminer si le chargement a eu lieu.
    boolean isDBEvaluated = false;

    // Soit une interface

    public interface Service {
        String info();
    }

    // Soit une implémentation du service

    public class DatabaseService implements Service {

        // Noter la mutation du flag lors de l'appel du constructeur
        public DatabaseService() {
            isDBEvaluated = true;
        }

        @Override
        public String info() {
            return "database";
        }
    }

    /**
     * Validation du chargement tardif sur une structure.
     */
    @Test
    public void test() {

        // TODO utiliser la méthode Lazy.val() pour créer une instance de DatabaseService
        // Le résultat est stockée dans une variable de type Service.
        Service service1 =  Lazy.val(() -> new DatabaseService(), Service.class);

        // validation qu'à ce stade DatabaseService n'est pas instancié
        assertThat(isDBEvaluated).isFalse();

        // TODO invoquer la méthode info du service
        String value =service1.info();

        assertThat(value).isEqualTo("database");

        // le service a bien été instancié.
        assertThat(isDBEvaluated).isTrue();
    }
}
