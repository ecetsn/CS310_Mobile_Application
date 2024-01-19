package com.example.studybuddy;

import java.time.LocalDate;

public class Entry {

    private String ID, location, description;
    private Course course;
    private User user;

    private LocalDate dateStudy, dateCreate;

    public Entry(String ID, String location, String description, Course course, User user, LocalDate dateStudy, LocalDate dateCreate) {
        this.ID = ID;
        this.location = location;
        this.description = description;
        this.course = course;
        this.user = user;
        this.dateStudy = dateStudy;
        this.dateCreate = dateCreate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateStudy() {
        return dateStudy;
    }

    public void setDateStudy(LocalDate dateStudy) {
        this.dateStudy = dateStudy;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "ID='" + ID + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", course=" + course +
                ", user=" + user +
                ", dateStudy=" + dateStudy +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
