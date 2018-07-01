package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.List;


/**
 * Exercice 02 - Fonction de transformation map.
 */
public class Lambda_02_Test {

    interface PersonToAccountMapper {
        Account map(Person p);
    }

    private List<Account> map(List<Person> personList, PersonToAccountMapper mapper) {
        // TODO implémenter la méthode pour transformer une liste de personnes en liste de comptes
        return null;
    }


    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de comptes
        // TODO tous les objets comptes ont un solde à 100 par défaut
        List<Account> result = map(personList, null);

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
        List<String> result = null;

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
}
