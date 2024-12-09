package org.rog.persondict.dao;

import org.rog.persondict.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    List<Person> findAll(int limit, int offset);
    Optional<Person> findById(int id);
    Optional<Integer> save(Person person);
    Optional<Person> update(Person person);
    void delete(int id);
}
