package org.rog.persondict.service;

import org.rog.persondict.PersonDictApp;
import org.rog.persondict.dao.PersonDao;
import org.rog.persondict.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService{
    @Value("${personDict.defaultSize}")
    private int defaultLimit;

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> findAllPersons(Integer pageSize, Integer pageNumber) {
        if(pageSize == null || pageNumber == null) {
            return personDao.findAll(defaultLimit, 0);
        }
        return personDao.findAll(pageSize, pageNumber);
    }

    @Override
    public Person findById(int id) {
        return personDao.findById(id).orElseThrow();
    }

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void update(int id, Person person) {
        personDao.update(id, person);
    }

    @Override
    public void delete(int id) {
        personDao.delete(id);
    }
}
