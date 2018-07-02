package dev.ex03_values;

import io.vavr.control.Option;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 03.1 : Option.
 */
public class Ex03_1_Option_Test {

    // Soit une classe représentant une personne
    class Person {
        String firstname;
    }

    // Soit une classe représentant un compte bancaire
    class Account {
        Person owner;
    }

    // TODO Compléter la méthode
    // A partir d'un compte bancaire, elle retourne le prenom du titulaire en majuscules.
    // Si le prenom n'est pas trouvé alors "" est retourné.
    String getUpperCaseFirstnameOfOwner(Account acc) {
        return Option.of(acc)
                .flatMap(a -> Option.of(a.owner))
                .flatMap(owner -> Option.of(owner.firstname))
                .map(first -> first.toUpperCase())
                .getOrElse("");
    }

    /**
     * Validation avec account == null;
     */
    @Test
    public void test_account_null() {

        Account acc = null;

        String result = getUpperCaseFirstnameOfOwner(acc);

        assertThat(result).isEqualTo("");

    }


    /**
     * Validation avec account.owner == null.
     */
    @Test
    public void test_owner_null() {

        Account acc = new Account();

        String result = getUpperCaseFirstnameOfOwner(acc);

        assertThat(result).isEqualTo("");

    }

    /**
     * Validation avec account.owner.firstname == null.
     */
    @Test
    public void test_firstname_null() {

        Account acc = new Account();
        acc.owner = new Person();

        String result = getUpperCaseFirstnameOfOwner(acc);

        assertThat(result).isEqualTo("");

    }

    /**
     * Validation avec account.owner.firstname valorisé..
     */
    @Test
    public void test_firstname_not_null() {

        Account acc = new Account();
        acc.owner = new Person();
        acc.owner.firstname = "Jean";

        String result = getUpperCaseFirstnameOfOwner(acc);

        assertThat(result).isEqualTo("JEAN");

    }
}
