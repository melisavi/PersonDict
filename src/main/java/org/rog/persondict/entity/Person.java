package org.rog.persondict.entity;

import java.time.LocalDate;
import java.util.Date;

public class Person {
    private int id;
    private String name;
    private int age;
    private LocalDate birthDate;

    public Person(int id, String name, LocalDate birthDate, int age) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}
