package org.rog.persondict;

import org.rog.persondict.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PersonDictApp {
    public static Map<Integer, Person> personMap = new HashMap<>();

    public static void main(String[] args){
        SpringApplication.run(PersonDictApp.class);
    }
}
