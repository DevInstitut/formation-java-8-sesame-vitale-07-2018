package java8.ex04;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Exercice 4 - java.util.function.Predicate
 */
public class Function_04_Test {

    // Soit une méthode de filtre.
    <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                result.add(el);
            }
        }
        return result;
    }

    // PART 1 - ADULT

    // TODO Compléter la fonction
    // TODO AGE >=18
    Predicate<Person> adult = null;

    /**
     * Validation de la fonction adult.
     *
     * @throws Exception
     */
    @Test
    public void test_predicate() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode filter pour que le test soit passant
        List<Person> result = null;

        assert result.size() == 4;

    }

    // PART 2 - ADULT AND LASTNAME=France AND FIRSTNAME=Armor

    // TODO compléter la fonction
    // TODO le prédicat vérifie que le nom est "France"
    Predicate<Person> lastnameIsFrance = null;


    // TODO compléter la fonction
    // TODO le prédicat vérifie que le prénom est "Armor"
    Predicate<Person> firstnameIsArmor = null;

    /**
     * Validation des fonctions lastnameIsFrance et firstnameIsArmor.
     * @throws Exception
     */
    @Test
    public void test_predicate_and() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode filter pour que le test soit passant
        // TODO chaîner les prédicats adult, lastnameIsFrance et firstnameIsArmor avec la méthode and
        List<Person> result = null;

        assert result.size() == 1;
        assert result.get(0).getFirstname().equals("Armor");
        assert result.get(0).getLastname().equals("France");
        assert result.get(0).getAge().equals(25);

    }
}
