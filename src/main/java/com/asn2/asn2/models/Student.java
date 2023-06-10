package com.asn2.asn2.models;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int weight;
    private int height;
    private String haircolour;
    private double gpa;
    private int age;
    private String gender;
    public Student() {
    }
    public Student(String name, int weight, int height, String haircolour, double gpa, int age, String gender) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.haircolour = haircolour;
        this.gpa = gpa;
        this.age = age;
        this.gender = gender;
    }
    
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public String getHaircolour() {
        return haircolour;
    }
    public void setHaircolour(String haircolour) {
        this.haircolour = haircolour;
    }

    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
