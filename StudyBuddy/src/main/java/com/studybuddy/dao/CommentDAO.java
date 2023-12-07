package com.studybuddy.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.studybuddy.model.Comment;
import com.studybuddy.model.Entry;
import com.studybuddy.model.User;

public interface CommentDAO extends MongoRepository<Comment,String> {
	
	List<Comment> findAll();
	
	public List<Comment> findByUser(User user);
	public List<Comment> findByEntry(Entry entry);
}