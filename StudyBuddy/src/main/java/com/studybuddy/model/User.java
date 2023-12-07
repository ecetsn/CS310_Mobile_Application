package com.studybuddy.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String id;
	
	@DBRef
	private List <Comment> comments;
	
	@DBRef
	private List <Entry> entries;
	
	private String name;
	private double gpa;
	private String educlass;
	
	public User() {
		
	}

	public User(String name, float gPA, String educlass, String iD, List<Comment> comments, List<Entry> entries) {
		super();
		this.name = name;
		this.gpa = gPA;
		this.educlass = educlass;
		this.id = iD;
		this.comments = comments;
		this.entries = entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGPA() {
		return this.gpa;
	}

	public void setGPA(double gPA) {
		this.gpa = gPA;
	}

	public String geteduclass() {
		return educlass;
	}

	public void seteduclass(String educlass) {
		this.educlass = educlass;
	}

	public String getID() {
		return this.id;
	}

	public void setID(String iD) {
		this.id = iD;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", comments=" + comments + ", entries=" + entries + ", name=" + name + ", gpa=" + gpa
				+ ", educlass=" + educlass + "]";
	}

}