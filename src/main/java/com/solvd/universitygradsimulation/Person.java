package com.solvd.universitygradsimulation;

public abstract class Person {
    private String name;
    private Integer age;

    public Person(){

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "Name: " + this.getName();
    }

    @Override
    public int hashCode() {
        int hash = 6*getAge() - 1;
        for(int i = 0; i < getName().length(); i++){
            hash = hash*31 + getName().charAt(i);
        }
        return hash;
    }

    public abstract boolean equals(Object obj);

}
