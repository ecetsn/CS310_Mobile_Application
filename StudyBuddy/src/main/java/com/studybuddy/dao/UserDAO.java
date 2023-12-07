package com.studybuddy.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.studybuddy.model.User;

public interface UserDAO extends MongoRepository<User,String> {
	
	//List<User> findAll();
	
	public List<User> findByGpa(double gpa);
	public List<User> findByName(String name);
	public List<User> findByEduclass(String educlass);
	
	//@Query("{edu_class:{$regex:?0,$options:'i'}}")
	//public List<User> findByClass(String edu_class); // sophomore, junior...
	
}
