package com.studybuddy.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.studybuddy.model.Course;

public interface CourseDAO extends MongoRepository<Course,String> {

	
	public Course findByName(String name);
	public Course findByCode(String code);
	
}