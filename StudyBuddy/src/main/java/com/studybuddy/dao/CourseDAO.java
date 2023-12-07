package com.studybuddy.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.studybuddy.model.Course;

public interface CourseDAO extends MongoRepository<Course,String> {

	//List<Course> findAll();
	//public List<Course> findByNameContainsIgnoreCase(String name);	
	//public List<Course> findByNameContainsIgnoreCase(User user);	// can be added later

	//@Query("{course_name:{$regex:?0,$options:'i'}}")
	public Course findByName(String name);
	public Course findByCode(String code);
	
	//@Query("{ $and: [ { 'course_name': { $regex: ?0, $options: 'i' } }, { 'course_code': { $regex: ?1, $options: 'i' } } ] }")
	//public Course findByNameAndCode(String courseName, String courseCode);

}