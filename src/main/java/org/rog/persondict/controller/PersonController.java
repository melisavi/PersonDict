package org.rog.persondict.controller;

import org.rog.persondict.entity.Person;
import org.rog.persondict.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(@RequestParam(name = "pageSize", required = false) Integer pageSize,
                                      @RequestParam(name = "pageNumber", required = false) Integer pageNumber){
        return personService.findAllPersons(pageSize, pageNumber);
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable(name = "id") int id){
        return personService.findById(id);
    }

    @PostMapping("/persons")
    public void savePerson(@RequestBody Person person){
        personService.save(person);
    }

    @PatchMapping("/persons/{id}")
    public void updatePerson(@PathVariable(name = "id") int id,
                             @RequestBody Person person){
        personService.update(id, person);
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable(name = "id") int id){
        personService.delete(id);
    }
}
