package org.rog.persondict.controller;

import org.rog.persondict.PersonDictApp;
import org.rog.persondict.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PersonController {
    public PersonController() {
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(@RequestParam(name = "pageSize", required = false) Integer pageSize,
                                      @RequestParam(name = "pageNumber", required = false) Integer pageNumber){
        System.out.println("We've got all persons: " + PersonDictApp.personList.toString());
        return PersonDictApp.personList;
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable(name = "id") int id){
        System.out.println("We've got the person");
        return PersonDictApp.personList.get(0);
    }

    @PostMapping("/persons")
    public void savePerson(@RequestBody Person person){
        PersonDictApp.personList.add(person);
        PersonDictApp.personList.get(0).setAge();
        System.out.println("We've saved the person");
    }

    @PatchMapping("/persons/{id}")
    public void updatePerson(@PathVariable(name = "id") int id,
                             @RequestBody String name){
        Person person = PersonDictApp.personList.get(0);
        person.setName(name);
        //person.setBirthDate(Date.from(birthDate));
        person.setAge();
        System.out.println("We've apdated the person");
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable(name = "id") int id){
        PersonDictApp.personList.remove(0);
        System.out.println("We've deleted the person");
    }
}
