package com.demo.sqlitedemo;

/**
 * Created by intel on 12/15/2016.
 */

public class Student {

    public final String name;
    public final String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }


}