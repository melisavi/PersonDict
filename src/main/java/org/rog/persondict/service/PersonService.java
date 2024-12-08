package org.rog.persondict.service;

import org.rog.persondict.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAllPersons(Integer pageSize, Integer pageNumber);
    Person findById(int id);
    void save(Person person);
    void update(int id, Person person);
    void delete(int id);
}
