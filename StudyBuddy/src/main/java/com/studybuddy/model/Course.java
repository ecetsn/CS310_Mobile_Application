package com.studybuddy.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Course {
	@Id
	private String id;
	
	@DBRef
	private List <Entry> entries;
	
	private String course_name;
	private String course_code;
	
	public Course() {
		
	}

	public Course(String course_name, String course_code) {
		super();
		this.course_name = course_name;
		this.course_code = course_code;
	}
	
	public Course(String course_name, String course_code, String id, List<Entry> entries) {
		super();
		this.course_name = course_name;
		this.course_code = course_code;
		this.id = id;
		this.entries = entries;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", entries=" + entries + ", course_name=" + course_name + ", course_code="
				+ course_code + "]";
	}

	
}