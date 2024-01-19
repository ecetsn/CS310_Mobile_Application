package com.studybuddy.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Comment {
	@Id
	private String id;	
	
	@DBRef
	private User user;
	
	@DBRef
	private Entry entry;
	
	private String message;
	private LocalDate date_commented;
	
	public Comment() {
		 
	}

	public Comment(User user, Entry entry, String message, LocalDate date_commented) {
		super();
		this.user = user;
		this.entry = entry;
		this.message = message;
		this.date_commented = date_commented;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate_commented() {
		return date_commented;
	}

	public void setDate_commented(LocalDate date_commented) {
		this.date_commented = date_commented;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", entry=" + entry + ", message=" + message
				+ ", date_commented=" + date_commented + "]";
	}
}