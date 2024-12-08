package org.rog.persondict.dao;

import org.rog.persondict.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    List<Person> findAll(int limit, int offset);
    Optional<Person> findById(int id);
    void save(Person person);
    void update(int id, Person person);
    void delete(int id);
}
