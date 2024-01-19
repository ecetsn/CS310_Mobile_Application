package com.example.studybuddy;

public class User {

    private String ID, name, educlass;
    private double dGPA;

    public User(String ID, String name, String educlass, double dGPA) {
        this.ID = ID;
        this.name = name;
        this.educlass = educlass;
        this.dGPA = dGPA;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEduclass() {
        return educlass;
    }

    public void setEduclass(String educlass) {
        this.educlass = educlass;
    }

    public double getdGPA() {
        return dGPA;
    }

    public void setdGPA(double dGPA) {
        this.dGPA = dGPA;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", educlass='" + educlass + '\'' +
                ", dGPA=" + dGPA +
                '}';
    }
}
