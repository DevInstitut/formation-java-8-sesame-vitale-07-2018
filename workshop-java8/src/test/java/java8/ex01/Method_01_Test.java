package java8.ex01;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;


/**
 * Exercice 01 - Méthode par défaut.
 */
public class Method_01_Test {

    // Soit une interface d'accès aux données.
    interface IDao {

        // Elle possède une méthode findAll() permettant de récupérer une liste de personnes.
        List<Person> findAll();

        // Nous souhaitons à présent créer une méthode qui calcule la somme des ages des personnes.
        //
        // TODO créer une méthode int sumAge()
        // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
        default int sumAge() {
            int sum = 0;
            for(Person p : findAll()) {
                sum += p.getAge();
            }
            return sum;
        }
    }

    // DaoA est une implémentation de IDao
    // Elle est constituée d'un jeu de données de 20 personnes.
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    // DaoA est une implémentation de IDao
    // Elle est constituée d'un jeu de données de 100 personnes.
    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    // Les 2 implémentations ayant un nombre de personnes différents, les résultats des sommes doivent l'être également.

    /**
     * Test avec l'implémentation DaoA.
     *
     * @throws Exception
     */
    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = daoA.sumAge();

        assert result == 210;
    }

    /**
     * Test avec l'implémentation DaoB.
     *
     * @throws Exception
     */
    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = daoB.sumAge();

        assert result == 5050;

    }
}
