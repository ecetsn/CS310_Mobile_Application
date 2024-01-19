package com.example.studybuddy;

import androidx.annotation.NonNull;

public class Course {
    private String id;
    private String name;
    private String code;

    public Course() {

    }

    public Course(String name, String code, String id) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return code + " " + name ;
    }


}
