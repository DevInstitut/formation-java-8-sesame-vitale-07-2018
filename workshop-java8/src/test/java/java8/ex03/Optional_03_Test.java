package java8.ex03;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 03 - Navigation avec map
 */
public class Optional_03_Test {

    class GoodException extends RuntimeException {
    }



    private Account getAccountWithPersonFirstnameNull() {
        Account account = new Account();
        account.setOwner(new Person());
        return account;
    }

    private Account getAccountWithPersonFirstnameNotNull() {
        Account account = new Account();
        account.setOwner(new Person("A", "B", 19, "C"));
        return account;
    }


    // TODO Implémenter la méthode findFirstname pour récupérer le prénom (account -> owner -> firstname)
    // Quelques indications :
    // - Utiliser la méthode map pour naviguer
    // - Utiliser la méthode orElseThrow pour déclencher l'exception GoodException si non trouvé
    private String findFirstname(Account account) throws GoodException {
        return null;
    }

    /**
     * Validation du cas où Account est null.
     *
     * @throws Exception
     */
    @Test(expected = GoodException.class)
    public void test_getAccountNull() throws Exception {
        Account account = null;
        String firstname = findFirstname(account); // devrait lancer une GoodException
        fail();
    }

    @Test(expected = GoodException.class)
    public void test_getAccountWithPersonNull() throws Exception {
        Account account = new Account(); // getOwner renvoie null
        String firstname = findFirstname(account); // devrait lancer une GoodException
        fail();
    }

    @Test(expected = GoodException.class)
    public void test_getAccountWithPersonFirstnameNull() throws Exception {
        Account account = new Account();
        account.setOwner(new Person()); // getFirstname() renvoie null
        String firstname = findFirstname(account); // devrait lancer une GoodException
        fail();
    }

    @Test
    public void test_getAccountWithPersonFirstnameNotNull() throws Exception {
        Account account = new Account();
        account.setOwner(new Person("A", "B", 19, "C"));

        String firstname = findFirstname(account); // devrait lancer une GoodException
        assert firstname.equals("A");
    }
}
