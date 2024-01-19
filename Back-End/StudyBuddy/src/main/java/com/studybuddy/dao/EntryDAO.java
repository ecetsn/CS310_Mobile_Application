package com.studybuddy.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.studybuddy.model.Course;
import com.studybuddy.model.Entry;
import com.studybuddy.model.User;

public interface EntryDAO extends MongoRepository<Entry,String> {
	
	public List<Entry> findByUser(User user);
	public List<Entry> findByCourse(Course course);
	public List<Entry> findByCourseCode(String courseCode);
	
	public List<Entry> findByLocationIgnoreCase(String location); // optional
	
	@Query("{'date_study': ?0 }")
	public List<Entry> findByDate(LocalDate dateCreate);	// optional
}