package com.studybuddy.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studybuddy.dao.CommentDAO;
import com.studybuddy.dao.CourseDAO;
import com.studybuddy.dao.EntryDAO;
import com.studybuddy.dao.UserDAO;
import com.studybuddy.model.Comment;
import com.studybuddy.model.Course;
import com.studybuddy.model.User;
import com.studybuddy.model.Entry;
import com.studybuddy.dao.UserDAO;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

//http://localhost:8000/studybuddy -> since it will connect to local host
@RestController
@RequestMapping("/studybuddy")
@EnableMongoRepositories(basePackages = {"com.studybuddy.dao"})
public class WebController {
	@Autowired private UserDAO userDao;
	@Autowired private CourseDAO courseDao;
	@Autowired private EntryDAO entryDao;
	@Autowired private CommentDAO commentDao;
	
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
		
		@PostConstruct
		public void init() {
		
			if(courseDao.count() == 0) {
				logger.info("Database is empty, initializing..");
				// add default courses like CS310, CS204 to the database
				Course courseCS201 = new Course("CS", "201");
				Course courseCS204 = new Course("CS", "204");
				Course courseCS310 = new Course("CS", "310");
				Course courseCS408 = new Course("CS", "408");			
				courseDao.save(courseCS201);
				courseDao.save(courseCS204);
				courseDao.save(courseCS310);
				courseDao.save(courseCS408);
				logger.info("All sample data saved!");
			}
						
		}
		
		// user collection
		@GetMapping("/users")
		public List<User> users(){
			return userDao.findAll();
		
		}
		
		@PostMapping("/users/save")
		public User saveUser(@RequestBody User user) {	
			User userSaved = userDao.save(user);
			return userSaved;
		}
		
		// comment collection
		@GetMapping("/comments")
		public List<Comment> comments(){
			return commentDao.findAll();
		
		}
		
		@PostMapping("/comments/save")
		public Comment saveComment(@RequestBody Comment comment) {	
			Comment commentSaved = commentDao.save(comment);
			return commentSaved;
		}
		
		
		// course collection
		@GetMapping("/course")
		public List<Course> courses(){
			return courseDao.findAll();
		
		}
		
		@PostMapping("/courses/save")
		public Course saveCourse(@RequestBody Course course) {	
			Course courseSaved = courseDao.save(course);
			return courseSaved;
		}
		

		// entry collection
		@GetMapping("/entry")
		public List<Entry> entries(){
			return entryDao.findAll();
		
		}
		
		@PostMapping("/entry/save")
		public Entry saveEntry(@RequestBody Entry entry) {	
			Entry entrySaved = entryDao.save(entry);
			return entrySaved;
		}
}
