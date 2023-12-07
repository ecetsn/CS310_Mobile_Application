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
	
	private String name;
	private String code;
	
	public Course() {
		
	}

	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	public Course(String name, String code, String id, List<Entry> entries) {
		super();
		this.name = name;
		this.code = code;
		this.id = id;
		this.entries = entries;
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

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", entries=" + entries + ", name=" + name + ", code="
				+ code + "]";
	}

	
}