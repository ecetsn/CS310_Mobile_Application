package com.studybuddy.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Entry {
	
	
    @Id
    private String id;
    
    private String location;
    private String description;
    private LocalDate dateStudy; 
    private LocalDate dateCreate; 

    @DBRef
    private Course course;
    
    @DBRef
    private User user;

	public Entry() {
		 
	}

	public Entry(String location, String description, LocalDate dateStudy, LocalDate dateCreate,
			Course course, User user) {
		super();
		this.location = location;
		this.description = description;
		this.dateStudy = dateStudy;
		this.dateCreate = dateCreate;
		this.course = course;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public LocalDate getdateStudy() {
		return dateStudy;
	}

	public void setdateStudy(LocalDate dateStudy) {
		this.dateStudy = dateStudy;
	}

	public LocalDate getdateCreate() {
		return dateCreate;
	}

	public void setdateCreate(LocalDate dateCreate) {
		this.dateCreate = dateCreate;
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

	@Override
	public String toString() {
		return "Entry [id=" + id + ", location=" + location + ", description=" + description + ", dateStudy="
				+ dateStudy + ", dateCreate=" + dateCreate + ", course=" + course + ", user=" + user + "]";
	}
	
	
}