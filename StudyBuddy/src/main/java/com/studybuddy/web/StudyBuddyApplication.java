package com.studybuddy.web;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.studybuddy.dao.CommentDAO;
import com.studybuddy.dao.CourseDAO;
import com.studybuddy.dao.EntryDAO;
import com.studybuddy.dao.UserDAO;
import com.studybuddy.model.Course;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.studybuddy.dao"})
public class StudyBuddyApplication implements CommandLineRunner{
	
	@Autowired UserDAO userDao;
	@Autowired CourseDAO courseDao;
	@Autowired EntryDAO entryDao;
	@Autowired CommentDAO commentDao;
	
	Logger logger = LoggerFactory.getLogger(StudyBuddyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StudyBuddyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// add default courses like CS310, CS204 to the database
		Course courseCS201 = new Course("CS", "201");
		Course courseCS204 = new Course("CS", "204");
		Course courseCS310 = new Course("CS", "310");
		Course courseCS408 = new Course("CS", "408");
		
		List<Course> courses = new ArrayList<>();
		courses.add(courseCS201);
		courses.add(courseCS204);
		courses.add(courseCS310);
		courses.add(courseCS408);
		courseDao.insert(courses);
		
		logger.info("Courses are added...");
		
		
		
	}

}
