package org.rog.persondict.entity;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private int age;
    private Date birthDate;

    public Person() {
    }

    public Person(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.age = (int) (new Date().getTime() - birthDate.getTime())/(24 * 60 * 60 * 1000)/365;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge() {
        System.out.println((new Date().getTime() - this.birthDate.getTime())/(24 * 60 * 60 * 1000)/365);
        this.age = 4;//(int) (new Date().getTime() - this.birthDate.getTime())/(24 * 60 * 60 * 1000)/365;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
