package com.studybuddy.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Course {
	@Id
	private String id;
	
	
	private String name;
	private String code;
	
	public Course() {
		
	}
	
	public Course(String name, String code) {
		super();
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
		return "Course [id=" + id + ", name=" + name + ", code="
				+ code + "]";
	}

	
}