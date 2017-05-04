package io.mart.javaEight;

/**
 * @author Alexander Martyushov
 */
public class Person {

    private String name;
    private String sureName;

    public Person(String name, String sureName) {
        this.name = name;
        this.sureName = sureName;
    }

    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                '}';
    }
}
