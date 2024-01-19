package com.studybuddy.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.studybuddy.model.User;

public interface UserDAO extends MongoRepository<User,String> {
		
	public List<User> findByGpa(double gpa);
	public List<User> findByName(String name);
	public List<User> findByEduclass(String educlass);
	
}
