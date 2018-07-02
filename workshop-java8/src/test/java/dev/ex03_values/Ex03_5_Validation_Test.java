package dev.ex03_values;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Exercice 03.5 : Validation.
 */
public class Ex03_5_Validation_Test {

    // Soit une structure personne.
    class Person {

        final String name;
        final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    // Soit une classe de validation.
    class PersonValidator {

        private static final int NAME_MIN_SIZE = 2;
        private static final int MIN_AGE = 18;

        Validation<String, String> validateName(String name) {
            // TODO
            // Si le nom a un nombre de caractères < à NAME_MIN_SIZE, le message d'invalidation est retournée (Validation.invalid("Invalid name size"))
            // Dans le cas où le nom est valide, il est retourné (Validation.valid(name);
            return null;
        }

        Validation<String, Integer> validateAge(int age) {
            // TODO
            // Si l'age < à MIN_AGE, le message d'invalidation est retournée (Validation.invalid("Invalid age (18 minimum)"))
            // Dans le cas où l'age est valide, il est retourné (Validation.valid(age);
            return null;

        }

        // Exemple de combinaison de validations
        Validation<Seq<String>, Person> validate(Person p) {

            Validation.Builder<String, String, Integer> vb = Validation.combine(validateName(p.name), validateAge(p.age));

            Validation<Seq<String>, Person> va = vb.ap((name, age) -> new Person(name, age));

            return va;
        }

    }

    /**
     * Cas d'une personne valide.
     */
    @Test
    public void test_valid() {
        Person validPerson = new Person("Jean", 40);
        PersonValidator personValidator = new PersonValidator();

        Validation<Seq<String>, Person> validation = personValidator.validate(validPerson);

        assertThat(validation.isValid()).isTrue();
        assertThat(validation.get().name).isEqualTo("Jean");
    }

    /**
     * Cas d'une personne invalide.
     */
    @Test
    public void test_invalid_name() {
        Person validPerson = new Person("J", 40);
        PersonValidator personValidator = new PersonValidator();

        Validation<Seq<String>, Person> validation = personValidator.validate(validPerson);

        assertThat(validation.isValid()).isFalse();
        assertThat(validation.getError().size()).isEqualTo(1);
        assertThat(validation.getError().single()).isEqualTo("Invalid name size");
    }

}
