package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;


/**
 * Exercice 02 - Fonction de transformation map.
 */
public class Lambda_02_Test {

    interface PersonToAccountMapper {
        Account map(Person p);
    }

    private List<Account> oldMap(List<Person> personList, PersonToAccountMapper mapper) {
        List<Account> accounts = new ArrayList<>();

        for(Person p : personList) {
            accounts.add(mapper.map(p));
        }

        return accounts;
    }

    interface GenericMapper<T,R> {
        R map(T a);
    }

    private <T,R> List<R> map(List<T> personList, GenericMapper<T,R> mapper) {
        List<R> accounts = new ArrayList<>();

        for(T p : personList) {
            accounts.add(mapper.map(p));
        }

        return accounts;
    }


    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de comptes
        // TODO tous les objets comptes ont un solde à 100 par défaut
        List<Account> result = map(personList, p ->  {
            Account a = new Account();
            a.setOwner(p);
            a.setBalance(100);
            return a;
        });


        assert result.size() == personList.size();
        for (Account account : result) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }


    // Maintenant que le premier test est passant, vous avez compris la notion de map.
    // TODO pourriez-vous modifier PersonToAccountMapper (à renommer en GenericMapper) et la méthode map pour que
    // ces structures puissent s'utiliser avec d'autres classes que Person et Account.

    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de prénoms grâce aux structures génériques crées précedemment.
        List<String> result = map(personList, Person::getFirstname);

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
}
