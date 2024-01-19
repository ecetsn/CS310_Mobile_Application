package com.studybuddy.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String id;
	

	
	private String name;
	private double gpa;
	private String educlass;
	
	public User() {
		
	}

	public User(String name, double gpa, String educlass) {
		super();
		this.name = name;
		this.gpa = gpa;
		this.educlass = educlass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getgpa() {
		return this.gpa;
	}

	public void setgpa(double gpa) {
		this.gpa = gpa;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gpa=" + gpa
				+ ", educlass=" + educlass + "]";
	}

}