package dev.repository;

import dev.domain.Person;
import io.vavr.collection.List;
import io.vavr.control.Option;
import org.springframework.data.repository.Repository;

public interface PersonJpaRepository extends Repository<Person, Long> {

    List<Person> findAll();
    void save(Person p);
    Option<Person> findById(Long id);

}
