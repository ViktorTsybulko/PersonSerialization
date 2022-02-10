package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String filename = "people.dat";

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Tom", 30, 175, false));
        people.add(new Person("Sam", 33, 178, true));
        people.add(new Person("Viktor", 19, 193, false));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        ArrayList<Person> newPeople= new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            newPeople=((ArrayList<Person>)ois.readObject());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        for(Person p : newPeople){
            System.out.println("Name: " + p.getName() + ", Age: " + p.getAge() + ", Height: " + p.getHeight()) ;
        }

        for(Person p : newPeople){
            System.out.println(p.getMarried());
        }
    }
}

