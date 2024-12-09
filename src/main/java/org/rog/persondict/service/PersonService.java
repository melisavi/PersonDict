package org.rog.persondict.service;

import org.rog.persondict.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAllPersons(Integer pageSize, Integer pageNumber);
    Person findById(int id);
    Integer save(Person person);
    Person update(Person person);
    void delete(int id);
}
