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
    private LocalDate dateStudy; 
    private LocalDate dateCreate; 

    @DBRef
    private Course course;
    
    @DBRef
    private User user;
    
    @DBRef
    private List<User> attendees;

    @DBRef
    private List <Comment> comments;

	public Entry() {
		 
	}

	public Entry(String id, String location, String description, LocalDate dateStudy, LocalDate dateCreate,
			Course course, User user, List<Comment> comments, List<User> attendees) {
		super();
		this.id = id;
		this.location = location;
		this.description = description;
		this.dateStudy = dateStudy;
		this.dateCreate = dateCreate;
		this.course = course;
		this.user = user;
		this.comments = comments;
		this.attendees = attendees;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", location=" + location + ", description=" + description + ", dateStudy="
				+ dateStudy + ", dateCreate=" + dateCreate + ", course=" + course + ", user=" + user + "]";
	}
	
	
}