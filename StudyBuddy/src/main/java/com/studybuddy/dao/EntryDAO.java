package com.studybuddy.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.studybuddy.model.Entry;
import com.studybuddy.model.User;

public interface EntryDAO extends MongoRepository<Entry,String> {

	List<Entry> findAll();
	
	public List<Entry> findByUser(User user);
	public List<Entry> findByCourseContainsIgnoreCase(String courseName);
	
	@Query("{'location': {$regex: ?0, $options: 'i'}}")
	public List<Entry> findByLocationIgnoreCase(String location);
	
	@Query("{'date_study': ?0 }")
	public List<Entry> findByDate(LocalDate dateStudy);
		
}