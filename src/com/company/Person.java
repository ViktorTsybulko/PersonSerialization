package com.company;

import java.io.*;

public class Person implements Serializable {

    private final String name;
    private final int age;
    private final double height;
    transient private final boolean married;

    Person(String n, int a, double h, boolean m){
        name=n;
        age=a;
        height=h;
        married=m;
    }

    String getName() {return name;}

    int getAge(){ return age;}

    double getHeight(){return height;}

    boolean getMarried(){return married;}

}
