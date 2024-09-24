package org.example.builder;

import org.example.builder.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder("Ivan", 34).build();

        System.out.println(person);
    }
}