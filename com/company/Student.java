package com.company;

public class Student extends Person {
    public Student(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String talk() {
        return name +"---"+ age + "---" + occupation;
    }
}
