package org.rog.persondict.dao;

import org.rog.persondict.PersonDictApp;
import org.rog.persondict.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Override
    public List<Person> findAll(int limit, int offset) {
        System.out.println("We've got all persons: " + PersonDictApp.personMap.toString());
        return PersonDictApp.personMap.values().stream().toList();
    }

    @Override
    public Optional<Person> findById(int id) {
        System.out.println("We've got the person");
        return Optional.of(PersonDictApp.personMap.get(id));
    }

    @Override
    public void save(Person person) {
        Integer newId = PersonDictApp.personMap.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
        PersonDictApp.personMap.put(newId, person);
        System.out.println("We've saved the person");
    }

    @Override
    public void delete(int id) {
        PersonDictApp.personMap.remove(id);
        System.out.println("We've deleted the person");
    }

    @Override
    public void update(int id, Person person) {
        PersonDictApp.personMap.put(id, person);
        System.out.println("We've apdated the person");
    }
}
