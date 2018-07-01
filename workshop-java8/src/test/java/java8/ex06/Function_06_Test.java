package java8.ex06;


import java8.data.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    // TODO compléter la méthode
    // TODO la méthode retourne une chaîne de caractères de la forme [age=<AGE>] (exemple : [age=12])
    String formatAge(Supplier<Person> supplier) {
        // TODO
        return null;
    }


    @Test
    public void test_supplier_formatAge() throws Exception {
        // TODO compléter le test unitaire pour qu'il soit passant
        String result = formatAge(null);

        assert result.equals("[age=35]");
    }

    @Test
    public void test_supplier_requireNonNull() throws Exception {

        // configuration du test JUnit pour que le test soit passant uniquement s'il y a un NullPointerException
        // et que le message est "require non null object"
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("require non null object");

        // TODO compléter le test unitaire pour qu'il soit passant
        Supplier<String> supplier = null;

        // Avec un paramètre null, cette méthode déclenche un NullPointerException
        // Laisser null en entrée.
        Objects.requireNonNull(null, supplier);

    }

}
