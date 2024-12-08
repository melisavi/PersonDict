package org.rog.persondict.service;

import org.rog.persondict.PersonDictApp;
import org.rog.persondict.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService{
    @Value("${personDict.defaultSize}")
    private int defaultLimit;

    @Override
    public List<Person> findAllPersons(Integer pageSize, Integer pageNumber) {
        System.out.println("We've got all persons: " + PersonDictApp.personMap.toString());
        return PersonDictApp.personMap.values().stream().toList();
    }

    @Override
    public Person findById(int id) {
        System.out.println("We've got the person");
        return PersonDictApp.personMap.get(id);
    }

    @Override
    public void save(Person person) {
        Integer newId = PersonDictApp.personMap.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
        PersonDictApp.personMap.put(newId, person);
        System.out.println("We've saved the person");
    }

    @Override
    public void update(int id, Person person) {
        PersonDictApp.personMap.put(id, person);
        System.out.println("We've apdated the person");
    }

    @Override
    public void delete(int id) {
        PersonDictApp.personMap.remove(id);
        System.out.println("We've deleted the person");
    }
}
