package org.rog.persondict;

import org.rog.persondict.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PersonDictApp {
    public static List<Person> personList = new ArrayList<Person>();

    public static void main(String[] args){
        SpringApplication.run(PersonDictApp.class);
    }
}
