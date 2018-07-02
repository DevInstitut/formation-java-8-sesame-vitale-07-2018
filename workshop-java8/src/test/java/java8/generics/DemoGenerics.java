package java8.generics;

import java8.data.Data;
import java8.data.Person;

import java.util.Arrays;
import java.util.List;

public class DemoGenerics {

    static class Employe<T /*extends Person*/> {

        String nom;
        T adresse;

        <E> List<E> test(List<E> superListe) {
            for (E e : superListe) {
                // fait quelque chose
            }

            return superListe;
        }


    }

    static class Adresse {
        String rue;
        String ville;
    }


    public static void main(String[] args) {

        Adresse adr1 = new Adresse();
        adr1.rue = "rue 1";
        adr1.ville = "ville 1";

        String adr2 = "rue 2 ville 2";

        Employe<Adresse> emp1 = new Employe();
        emp1.nom = "Nom 1";
        emp1.adresse = adr1;

        Employe<String> emp2 = new Employe();
        emp2.adresse = adr2;


        List<String> strings = emp1.test(Arrays.asList("A", "B", "C"));

        List<Person> people = emp1.test(Data.buildPersonList(3));

    }
}
