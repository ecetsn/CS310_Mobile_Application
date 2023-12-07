package com.studybuddy.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Entry {

    @Id
    private String id;
    
    private String location;
    private String description;
    private LocalDate date_study; 
    private LocalDate date_create; 

    @DBRef
    private Course course;
    
    @DBRef
    private User user;

    @DBRef
    private List <Comment> comments;

	public Entry() {
		 
	}

	public Entry(String id, String location, String description, LocalDate date_study, LocalDate date_create,
			Course course, User user, List<Comment> comments) {
		super();
		this.id = id;
		this.location = location;
		this.description = description;
		this.date_study = date_study;
		this.date_create = date_create;
		this.course = course;
		this.user = user;
		this.comments = comments;
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

	public LocalDate getDate_study() {
		return date_study;
	}

	public void setDate_study(LocalDate date_study) {
		this.date_study = date_study;
	}

	public LocalDate getDate_create() {
		return date_create;
	}

	public void setDate_create(LocalDate date_create) {
		this.date_create = date_create;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", location=" + location + ", description=" + description + ", date_study="
				+ date_study + ", date_create=" + date_create + ", course=" + course + ", user=" + user + "]";
	}
}