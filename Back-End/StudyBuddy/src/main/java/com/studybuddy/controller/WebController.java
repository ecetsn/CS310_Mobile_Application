package com.studybuddy.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;

//http://localhost:8080/studybuddy -> since it will connect to local host
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
			if(userDao.count() == 0) {
				logger.info("Initializing Users...");
				
				User User1 = new User("GoktugAygun", 1.00 ,"Junior");
				User User2 = new User("EfeBallar", 2.00 ,"Junior");
				User User3 = new User("ElifEceTosun", 2.20 ,"Junior");
				User User4 = new User("MertRodop", 2.00 ,"Junior");
				User User5 = new User("AlpNuhoglu", 1.80 ,"Prep");
				User User6 = new User("KamerKaya", 4.00 ,"Sophomore");
				User User7 = new User("AlbertLevi", 2.72 ,"Prep");
				User User8 = new User("OnurVarol", 3.10 ,"Freshman");
				User User9 = new User("EsraErdem", 3.40 ,"Junior");
				User User10 = new User("YusufLeblebici", 2.65 ,"Senior");
				User User11 = new User("JackSparrow", 1.10 ,"Senior");
				User User12 = new User("BuzzLightyear", 3.00 ,"Freshman");
				User User13 = new User("EkremImamoglu", 3.20 ,"Freshman");
				User User14 = new User("LionelMessi", 2.30 ,"Prep");
				User User15 = new User("AsyaDeniz", 3.50 ,"Sophomore");
				User User16 = new User("KaanOzturk", 2.85 ,"Junior");
				User User17 = new User("EmineGuler", 1.90 ,"Prep");
				User User18 = new User("CemYildiz", 3.25 ,"Senior");
				User User19 = new User("BerkayKara", 2.70 ,"Freshman");
				User User20 = new User("NazSahin", 2.20 ,"Junior");
				User User21 = new User("FiratAydin", 3.80 ,"Sophomore");
				User User22 = new User("ElifUcar", 2.95 ,"Prep");
				User User23 = new User("YasinYigit", 2.10 ,"Junior");
				User User24 = new User("HaticeBulut", 1.50 ,"Freshman");
				User User25 = new User("MehmetErdogan", 3.15 ,"Senior");
				User User26 = new User("BilgeAslan", 2.40 ,"Prep");
				User User27 = new User("DenizSahin", 2.75 ,"Freshman");
				User User28 = new User("YagmurTosun", 3.65 ,"Sophomore");
				User User29 = new User("HakanYildirim", 2.30 ,"Junior");
				User User30 = new User("BerkCetin", 1.70 ,"Prep");
				User User31 = new User("DuruKoc", 3.95 ,"Senior");
				User User32 = new User("BurakYilmaz", 2.55 ,"Freshman");
				User User33 = new User("EbruSahin", 3.20 ,"Junior");
				User User34 = new User("UmutOzkan", 2.85 ,"Sophomore");
				User User35 = new User("EfeSahin", 1.80 ,"Prep");
				User User36 = new User("YusufTuncer", 3.70 ,"Senior");
				User User37 = new User("BerkayAslan", 2.10 ,"Freshman");
				User User38 = new User("ElifKara", 2.40 ,"Prep");
				User User39 = new User("AhmetUzun", 3.25 ,"Junior");
				User User40 = new User("ZeynepOzdemir", 2.90 ,"Sophomore");
				User User41 = new User("YildizAydin", 1.95 ,"Prep");
				User User42 = new User("MustafaErdogan", 3.60 ,"Senior");
				User User43 = new User("EmreOzturk", 2.20 ,"Freshman");
				User User44 = new User("CemreYildiz", 2.70 ,"Prep");
				User User45 = new User("BilgeSahin", 3.40 ,"Sophomore");
				User User46 = new User("HuseyinKara", 2.80 ,"Junior");
				User User47 = new User("EgeAslan", 1.75 ,"Prep");
				User User48 = new User("AsyaYilmaz", 3.10 ,"Senior");
				User User49 = new User("KuzeyBulut", 2.50 ,"Freshman");
				User User50 = new User("DilaraSahin", 2.65 ,"Junior");
				User User51 = new User("ElifKaya", 3.20 ,"Sophomore");
				User User52 = new User("BerkayArslan", 2.75 ,"Junior");
				User User53 = new User("EbruYildirim", 1.90 ,"Prep");
				User User54 = new User("MehmetUzun", 3.35 ,"Senior");
				User User55 = new User("DenizErdogan", 2.70 ,"Freshman");
				User User56 = new User("YagmurSahin", 2.15 ,"Junior");
				User User57 = new User("BilgeBulut", 4.00 ,"Sophomore");
				User User58 = new User("KaanYildiz", 2.95 ,"Prep");
				User User59 = new User("HaticeKara", 2.10 ,"Junior");
				User User60 = new User("AsyaCelik", 1.60 ,"Freshman");
				User User61 = new User("CemreKoc", 3.25 ,"Senior");
				User User62 = new User("EmirSahin", 2.40 ,"Prep");
				User User63 = new User("NazErdogan", 2.85 ,"Freshman");
				User User64 = new User("HakanYildiz", 3.70 ,"Sophomore");
				User User65 = new User("KuzeyOzturk", 2.20 ,"Junior");
				User User66 = new User("EceAydin", 3.50 ,"Prep");
				User User67 = new User("BerkayAslan", 2.65 ,"Senior");
				User User68 = new User("YasinSahin", 1.80 ,"Freshman");
				User User69 = new User("FiratKaya", 3.15 ,"Junior");
				User User70 = new User("EsraUcar", 2.90 ,"Sophomore");
				User User71 = new User("ElifGuler", 1.95 ,"Prep");
				User User72 = new User("MustafaOzdemir", 3.60 ,"Senior");
				User User73 = new User("EfeBulut", 2.25 ,"Freshman");
				User User74 = new User("BerkTosun", 2.80 ,"Prep");
				User User75 = new User("YigitYildirim", 3.45 ,"Sophomore");
				User User76 = new User("BurakKoc", 2.50 ,"Junior");
				User User77 = new User("EmineArslan", 1.85 ,"Prep");
				User User78 = new User("ZeynepSahin", 3.30 ,"Senior");
				User User79 = new User("CemilKaya", 2.60 ,"Freshman");
				User User80 = new User("EzgiYildiz", 2.75 ,"Junior");
				User User81 = new User("KeremBulut", 1.70 ,"Prep");
				User User82 = new User("ElifErdogan", 3.80 ,"Senior");
				User User83 = new User("KamilOzdemir", 2.35 ,"Freshman");
				User User84 = new User("ElaSahin", 3.05 ,"Prep");
				User User85 = new User("BerkayKoc", 2.70 ,"Senior");
				User User86 = new User("EceYilmaz", 2.45 ,"Freshman");
				User User87 = new User("EfeKara", 3.90 ,"Senior");
				User User88 = new User("AsyaGuler", 2.15 ,"Prep");
				User User89 = new User("FiratAydin", 3.55 ,"Senior");
				User User90 = new User("EsraKoc", 2.80 ,"Freshman");
				User User91 = new User("YusufSahin", 3.20 ,"Junior");
				User User92 = new User("EmirErdogan", 2.65 ,"Sophomore");
				User User93 = new User("BegumYildiz", 1.75 ,"Prep");
				User User94 = new User("MehmetBulut", 3.40 ,"Senior");
				User User95 = new User("AsliKaya", 2.90 ,"Freshman");
				User User96 = new User("BerkayOzdemir", 3.10 ,"Prep");
				User User97 = new User("ElifYilmaz", 2.75 ,"Senior");
				User User98 = new User("AliSahin", 2.20 ,"Freshman");
				User User99 = new User("AyseErdogan", 2.50 ,"Junior");
				User User100 = new User("HakanYildiz", 3.70 ,"Sophomore");



				userDao.save(User1);
				userDao.save(User2);
				userDao.save(User3);
				userDao.save(User4);
				userDao.save(User5);
				userDao.save(User6);
				userDao.save(User7);
				userDao.save(User8);
				userDao.save(User9);
				userDao.save(User10);
				userDao.save(User11);
				userDao.save(User12);
				userDao.save(User13);
				userDao.save(User14);
				userDao.save(User15);
				userDao.save(User16);
				userDao.save(User17);
				userDao.save(User18);
				userDao.save(User19);
				userDao.save(User20);
				userDao.save(User21);
				userDao.save(User22);
				userDao.save(User23);
				userDao.save(User24);
				userDao.save(User25);
				userDao.save(User26);
				userDao.save(User27);
				userDao.save(User28);
				userDao.save(User29);
				userDao.save(User30);
				userDao.save(User31);
				userDao.save(User32);
				userDao.save(User33);
				userDao.save(User34);
				userDao.save(User35);
				userDao.save(User36);
				userDao.save(User37);
				userDao.save(User38);
				userDao.save(User39);
				userDao.save(User40);
				userDao.save(User41);
				userDao.save(User42);
				userDao.save(User43);
				userDao.save(User44);
				userDao.save(User45);
				userDao.save(User46);
				userDao.save(User47);
				userDao.save(User48);
				userDao.save(User49);
				userDao.save(User50);
				userDao.save(User51);
				userDao.save(User52);
				userDao.save(User53);
				userDao.save(User54);
				userDao.save(User55);
				userDao.save(User56);
				userDao.save(User57);
				userDao.save(User58);
				userDao.save(User59);
				userDao.save(User60);
				userDao.save(User61);
				userDao.save(User62);
				userDao.save(User63);
				userDao.save(User64);
				userDao.save(User65);
				userDao.save(User66);
				userDao.save(User67);
				userDao.save(User68);
				userDao.save(User69);
				userDao.save(User70);
				userDao.save(User71);
				userDao.save(User72);
				userDao.save(User73);
				userDao.save(User74);
				userDao.save(User75);
				userDao.save(User76);
				userDao.save(User77);
				userDao.save(User78);
				userDao.save(User79);
				userDao.save(User80);
				userDao.save(User81);
				userDao.save(User82);
				userDao.save(User83);
				userDao.save(User84);
				userDao.save(User85);
				userDao.save(User86);
				userDao.save(User87);
				userDao.save(User88);
				userDao.save(User89);
				userDao.save(User90);
				userDao.save(User91);
				userDao.save(User92);
				userDao.save(User93);
				userDao.save(User94);
				userDao.save(User95);
				userDao.save(User96);
				userDao.save(User97);
				userDao.save(User98);
				userDao.save(User99);
				userDao.save(User100);

				logger.info("All users are saved!");
			}
			
			if(courseDao.count() == 0) {
				logger.info("Initializing Courses...");
				
				Course ACC201 = new Course("Financial Accounting and Reporting", "ACC201");
				Course ACC301 = new Course("Managerial Accounting", "ACC301");
				Course ACC401 = new Course("Intermediate Financial Accounting and Reporting", "ACC401");
				Course ACC402 = new Course("Advanced Issues in Financial Accounting", "ACC402");
				Course ACC403 = new Course("Auditing", "ACC403");
				Course ACC404 = new Course("International Accounting", "ACC404");
				Course ACC405 = new Course("Financial Statement Analysis", "ACC405");
				Course ACC406 = new Course("Intermediate Managerial Accounting", "ACC406");
				Course ACC450 = new Course("Selected Topics in Accounting I", "ACC450");
				Course ACC451 = new Course("Selected Topics in Accounting II", "ACC451");

				Course AL102 = new Course("Academic Literacies", "AL102");

				Course ANTH214 = new Course("Anthropology as Cultural Critique", "ANTH214");
				Course ANTH251 = new Course("Anthropology of the Global City", "ANTH251");
				Course ANTH465 = new Course("Social Mobilization, Resistance and Protest", "ANTH465");
				Course ANTH468 = new Course("Ethnography: Fieldwork and Writing in Anthropology", "ANTH468");
				Course ANTH469 = new Course("Anthropology and History", "ANTH469");
				Course ANTH471 = new Course("Anthropology of Europe", "ANTH471");

				Course ARA110 = new Course("Basic Arabic I", "ARA110");
				Course ARA120 = new Course("Basic Arabic II", "ARA120");
				Course ARA130 = new Course("Intermediate Arabic I", "ARA130");
				Course ARA140 = new Course("Intermediate Arabic II", "ARA140");
				Course ARA150 = new Course("Advanced Arabic I", "ARA150");
				Course ARA160 = new Course("Advanced Arabic II", "ARA160");

				Course BIO301 = new Course("Introduction to Molecular Biology", "BIO301");
				Course BIO303 = new Course("Genetics", "BIO303");
				Course BIO304 = new Course("Biological Function and Structure", "BIO304");
				Course BIO306 = new Course("Microbiology", "BIO306");
				Course BIO308 = new Course("Plant Physiology", "BIO308");
				Course BIO310 = new Course("Introduction to Bioinformatics", "BIO310");
				Course BIO321 = new Course("Biochemistry I", "BIO321");
				Course BIO322 = new Course("Biochemistry II", "BIO322");
				Course BIO330 = new Course("Environmental Plant Biology", "BIO330");
				Course BIO332 = new Course("Cell Biology", "BIO332");
				Course BIO335 = new Course("Analytical Techniques", "BIO335");
				Course BIO363 = new Course("Ecology", "BIO363");
				Course BIO370 = new Course("Mammalian Cell Culture", "BIO370");
				Course BIO395 = new Course("Internship Project", "BIO395");
				Course BIO404 = new Course("Plant Biotechnology", "BIO404");
				Course BIO407 = new Course("Multicellular Organization", "BIO407");
				Course BIO415 = new Course("Plant Nutrition", "BIO415");
				Course BIO421 = new Course("Tissue Engineering", "BIO421");
				Course BIO423 = new Course("Neurobiology", "BIO423");
				Course BIO436 = new Course("Cancer Biology", "BIO436");
				Course BIO444 = new Course("Bioengineering", "BIO444");
				Course BIO445 = new Course("Plant Tissue Culture Techniques", "BIO445");
				Course BIO446 = new Course("Biology of Aging", "BIO446");
				Course BIO452 = new Course("Immunology", "BIO452");
				Course BIO467 = new Course("Signal Transduction", "BIO467");
				Course BIO468 = new Course("Gene Regulation & Disease", "BIO468");

				Course CHEM202 = new Course("Chemical Kinetics", "CHEM202");
				Course CHEM301 = new Course("Inorganic Chemistry", "CHEM301");
				Course CHEM302 = new Course("Analytical Chemistry", "CHEM302");
				Course CHEM369 = new Course("Chemistry of Transformable Materials", "CHEM369");
				Course CHEM405 = new Course("Electrochemistry", "CHEM405");
				Course CHEM421 = new Course("Clean Coal Technology", "CHEM421");

				Course CHI110 = new Course("Basic Chinese I", "CHI110");
				Course CHI120 = new Course("Basic Chinese II", "CHI120");
				Course CHI130 = new Course("Intermediate Chinese I", "CHI130");
				Course CHI140 = new Course("Intermediate Chinese II", "CHI140");

				Course CIP101 = new Course("Civic Involvement Projects I", "CIP101");
				Course CONF300 = new Course("Conflict Analysis and Resolution", "CONF300");
				Course CONF400 = new Course("International Conflict and Peace", "CONF400");
				Course CONF431 = new Course("Conflict Resolution Practice", "CONF431");

				Course CS201 = new Course("Programming Fundamentals", "CS201");
				Course CS204 = new Course("Advanced Programming", "CS204");
				Course CS210 = new Course("Introduction to Data Science", "CS210");
				Course CS300 = new Course("Data Structures", "CS300");
				Course CS301 = new Course("Algorithms", "CS301");
				Course CS302 = new Course("Formal Languages and Automata Theory", "CS302");
				Course CS303 = new Course("Logic and Digital System Design", "CS303");
				Course CS305 = new Course("Programming Languages", "CS305");
				Course CS306 = new Course("Database Systems", "CS306");
				Course CS307 = new Course("Operating Systems", "CS307");
				Course CS308 = new Course("Software Engineering", "CS308");
				Course CS310 = new Course("Mobile Application Development", "CS310");
				Course CS395 = new Course("Internship Project", "CS395");
				Course CS400 = new Course("Logic in Computer Science", "CS400");
				Course CS401 = new Course("Computer Architectures", "CS401");
				Course CS402 = new Course("Compiler Design", "CS402");
				Course CS403 = new Course("Distributed Systems", "CS403");
				Course CS404 = new Course("Artificial Intelligence", "CS404");
				Course CS405 = new Course("Computer Graphics", "CS405");
				Course CS406 = new Course("Parallel Computing", "CS406");
				Course CS407 = new Course("Theory of Computation", "CS407");
				Course CS408 = new Course("Computer Networks", "CS408");
				Course CS411 = new Course("Cryptography", "CS411");
				Course CS412 = new Course("Machine Learning", "CS412");
				Course CS414 = new Course("Network Science", "CS414");
				Course CS419 = new Course("Digital Image and Video Analysis", "CS419");
				Course CS432 = new Course("Computer and Network Security", "CS432");
				Course CS437 = new Course("Cybersecurity Practices and Applications", "CS437");
				Course CS438 = new Course("Blockchain: Security and Applications", "CS438");
				Course CS439 = new Course("Software Verification and Validation", "CS439");
				Course CS442 = new Course("Software Design Patterns", "CS442");
				Course CS445 = new Course("Natural Language Processing", "CS445");
				Course CS449 = new Course("Human-Computer Interaction", "CS449");
				Course CS48004 = new Course("Special Topics in CS: Agile Software Development", "CS48004");
				Course CS48006 = new Course("Special Topics in CS: Decentralized Finance", "CS48006");
				Course CS48007 = new Course("Special Topics in CS: Internet of Things Sensing System", "CS48007");

				
				// Economics course
				Course ECON201 = new Course("Games and Strategies", "ECON201");
				Course ECON202 = new Course("Macroeconomics", "ECON202");
				Course ECON204 = new Course("Microeconomics", "ECON204");
				Course ECON300 = new Course("Project and Internship", "ECON300");
				Course ECON301 = new Course("Econometrics", "ECON301");
				Course ECON310 = new Course("Game Theory", "ECON310");
				Course ECON312 = new Course("Behavioral Economics", "ECON312");
				Course ECON320 = new Course("Public Economics", "ECON320");
				Course ECON321 = new Course("Education Economics and Policy", "ECON321");
				Course ECON322 = new Course("Health Economics and Policy", "ECON322");
				Course ECON323 = new Course("Energy and Environmental Economics", "ECON323");
				Course ECON330 = new Course("Industrial Organization", "ECON330");
				Course ECON335 = new Course("Economics of Information", "ECON335");
				Course ECON340 = new Course("International Economics", "ECON340");
				Course ECON341 = new Course("Corporate Finance", "ECON341");
				Course ECON345 = new Course("International Finance", "ECON345");
				Course ECON346 = new Course("Global Finance and Multinational Corporation", "ECON346");
				Course ECON347 = new Course("Essentials of Project and Infrastructure Finance", "ECON347");
				Course ECON350 = new Course("Financial Institutions and Markets", "ECON350");
				Course ECON360 = new Course("Advanced Macroeconomics", "ECON360");
				Course ECON370 = new Course("Advanced Microeconomics", "ECON370");
				Course ECON391 = new Course("Topics in Macroeconomics: Emerging Market Macroeconomics", "ECON391");
				Course ECON399 = new Course("Independent Study", "ECON399");
				Course ECON400 = new Course("History of Economic Thought", "ECON400");
				Course ECON401 = new Course("Applied Econometrics", "ECON401");
				Course ECON403 = new Course("Economic History", "ECON403");
				Course ECON405 = new Course("Law and Economics", "ECON405");
				Course ECON407 = new Course("The Political Economy of European Integration", "ECON407");
				
				Course EE200 = new Course("Electronic Circuit Implementations", "EE200");
				Course EE202 = new Course("Electronic Circuits II", "EE202");
				Course EE301 = new Course("Electromagnetics II", "EE301");
				Course EE302 = new Course("Digital Integrated Circuits", "EE302");
				Course EE303 = new Course("Analog Integrated Circuits", "EE303");
				Course EE306 = new Course("Introduction to Radio Frequency and Microwave Design", "EE306");
				Course EE307 = new Course("Semiconductor Physics and Devices", "EE307");
				Course EE308 = new Course("Microcomputer Based System Design", "EE308");
				Course EE310 = new Course("Hardware Description Languages", "EE310");
				Course EE311 = new Course("Introduction to Signal Processing and Information Systems", "EE311");
				Course EE312 = new Course("Discrete-Time Signals and Systems", "EE312");
				
				Course ENS201 = new Course("Electromagnetics I", "ENS201");
				Course ENS202 = new Course("Thermodynamics", "ENS202");
				Course ENS203 = new Course("Electronic Circuits I", "ENS203");
				Course ENS204 = new Course("Mechanics", "ENS204");
				Course ENS205 = new Course("Introduction to Materials Science", "ENS205");
				Course ENS206 = new Course("Systems Modeling and Control", "ENS206");
				Course ENS207 = new Course("Introduction to Energy Systems", "ENS207");
				Course ENS208 = new Course("Introduction to Industrial Engineering", "ENS208");
				Course ENS209 = new Course("Introduction to Computer Aided Drafting and Solid Modeling", "ENS209");
				Course ENS210 = new Course("Computational Biology", "ENS210");
				
				// Humanities courses
				Course HUM201 = new Course("Major Works of Literature", "HUM201");
				Course HUM202 = new Course("Major Works of Western Art", "HUM202");
				Course HUM207 = new Course("Major Works of Western Philosophy", "HUM207");
				Course HUM311 = new Course("Major Works of Literature: The World Before Modernity", "HUM311");
				
				// Operations Research course
				Course IE302 = new Course("Stochastic Models in Operations Research", "IE302");
				Course IE303 = new Course("Decision Economics", "IE303");
				Course IE304 = new Course("Production and Service Systems Planning and Design", "IE304");
				Course IE305 = new Course("Simulation", "IE305");
				Course IE306 = new Course("Human Factors Engineering", "IE306");
				
				// Faculty of Engineering and Natural Sciences courses
				Course IF100 = new Course("Computational Approaches to Problem Solving", "IF100");
				Course IF200 = new Course("Fantasy, Reality, Science and Society", "IF200");
				Course IF301 = new Course("Gender in Science and Technology", "IF301");
				Course IF333 = new Course("Creativity, Innovation and Entrepreneurship", "IF333");
				Course IF467 = new Course("Decision, Psychology and Brain", "IF467");

								
				courseDao.save(ACC201);
				courseDao.save(ACC301);
				courseDao.save(ACC401);
				courseDao.save(ACC402);
				courseDao.save(ACC403);
				courseDao.save(ACC404);
				courseDao.save(ACC405);
				courseDao.save(ACC406);
				courseDao.save(ACC450);
				courseDao.save(ACC451);

				courseDao.save(AL102);

				courseDao.save(ANTH214);
				courseDao.save(ANTH251);
				courseDao.save(ANTH465);
				courseDao.save(ANTH468);
				courseDao.save(ANTH469);
				courseDao.save(ANTH471);

				courseDao.save(ARA110);
				courseDao.save(ARA120);
				courseDao.save(ARA130);
				courseDao.save(ARA140);
				courseDao.save(ARA150);
				courseDao.save(ARA160);

				courseDao.save(BIO301);
				courseDao.save(BIO303);
				courseDao.save(BIO304);
				courseDao.save(BIO306);
				courseDao.save(BIO308);
				courseDao.save(BIO310);
				courseDao.save(BIO321);
				courseDao.save(BIO322);
				courseDao.save(BIO330);
				courseDao.save(BIO332);
				courseDao.save(BIO335);
				courseDao.save(BIO363);
				courseDao.save(BIO370);
				courseDao.save(BIO395);
				courseDao.save(BIO404);
				courseDao.save(BIO407);
				courseDao.save(BIO415);
				courseDao.save(BIO421);
				courseDao.save(BIO423);
				courseDao.save(BIO436);
				courseDao.save(BIO444);
				courseDao.save(BIO445);
				courseDao.save(BIO446);
				courseDao.save(BIO452);
				courseDao.save(BIO467);
				courseDao.save(BIO468);

				courseDao.save(CHEM202);
				courseDao.save(CHEM301);
				courseDao.save(CHEM302);
				courseDao.save(CHEM369);
				courseDao.save(CHEM405);
				courseDao.save(CHEM421);

				courseDao.save(CHI110);
				courseDao.save(CHI120);
				courseDao.save(CHI130);
				courseDao.save(CHI140);

				courseDao.save(CIP101);
				courseDao.save(CONF300);
				courseDao.save(CONF400);
				courseDao.save(CONF431);
				
				// Computer Science courses
				courseDao.save(CS201);
				courseDao.save(CS204);
				courseDao.save(CS210);
				courseDao.save(CS300);
				courseDao.save(CS301);
				courseDao.save(CS302);
				courseDao.save(CS303);
				courseDao.save(CS305);
				courseDao.save(CS306);
				courseDao.save(CS307);
				courseDao.save(CS308);
				courseDao.save(CS310);
				courseDao.save(CS395);
				courseDao.save(CS400);
				courseDao.save(CS401);
				courseDao.save(CS402);
				courseDao.save(CS403);
				courseDao.save(CS404);
				courseDao.save(CS405);
				courseDao.save(CS406);
				courseDao.save(CS407);
				courseDao.save(CS408);
				courseDao.save(CS411);
				courseDao.save(CS412);
				courseDao.save(CS414);
				courseDao.save(CS419);
				courseDao.save(CS432);
				courseDao.save(CS437);
				courseDao.save(CS438);
				courseDao.save(CS439);
				courseDao.save(CS442);
				courseDao.save(CS445);
				courseDao.save(CS449);
				courseDao.save(CS48004);
				courseDao.save(CS48006);
				courseDao.save(CS48007);

				
				// Economics courses
				courseDao.save(ECON201);
				courseDao.save(ECON202);
				courseDao.save(ECON204);
				courseDao.save(ECON300);
				courseDao.save(ECON301);
				courseDao.save(ECON310);
				courseDao.save(ECON312);
				courseDao.save(ECON320);
				courseDao.save(ECON321);
				courseDao.save(ECON322);
				courseDao.save(ECON323);
				courseDao.save(ECON330);
				courseDao.save(ECON335);
				courseDao.save(ECON340);
				courseDao.save(ECON341);
				courseDao.save(ECON345);
				courseDao.save(ECON346);
				courseDao.save(ECON347);
				courseDao.save(ECON350);
				courseDao.save(ECON360);
				courseDao.save(ECON370);
				courseDao.save(ECON391);
				courseDao.save(ECON399);
				courseDao.save(ECON400);
				courseDao.save(ECON401);
				courseDao.save(ECON403);
				courseDao.save(ECON405);
				courseDao.save(ECON407);
				
				courseDao.save(EE200);
				courseDao.save(EE202);
				courseDao.save(EE301);
				courseDao.save(EE302);
				courseDao.save(EE303);
				courseDao.save(EE306);
				courseDao.save(EE307);
				courseDao.save(EE308);
				courseDao.save(EE310);
				courseDao.save(EE311);
				courseDao.save(EE312);
				courseDao.save(ENS201);
				courseDao.save(ENS202);
				courseDao.save(ENS203);
				courseDao.save(ENS204);
				courseDao.save(ENS205);
				courseDao.save(ENS206);
				courseDao.save(ENS207);
				courseDao.save(ENS208);
				courseDao.save(ENS209);
				courseDao.save(ENS210);
				courseDao.save(HUM201);
				courseDao.save(HUM202);
				courseDao.save(HUM207);
				courseDao.save(HUM311);
			
				courseDao.save(IE302);
				courseDao.save(IE303);
				courseDao.save(IE304);
				courseDao.save(IE305);
				courseDao.save(IE306);
				
				courseDao.save(IF100);
				courseDao.save(IF200);
				courseDao.save(IF301);
				courseDao.save(IF333);
				courseDao.save(IF467);
				

				logger.info("All courses are saved!");
			}
			

			if(entryDao.count() == 0 && userDao.count() != 0 && courseDao.count() != 0) {
				
				LocalDate date = LocalDate.of(2023, 12, 30);
				LocalTime time = LocalTime.of(21, 0); // 9:00 PM

				// Combine LocalDate and LocalTime to create LocalDateTime
				LocalDateTime dateTime = date.atTime(time);

				// Extract LocalDate from LocalDateTime
				LocalDate result = dateTime.toLocalDate();
				String[] eventTypes = {"Midterm", "Final", "ADP workshop", "Office Hour", "Study Session"};
				logger.info("Initializing Entries...");
				Random random = new Random();
				for (int i = 0; i < 50;i++) 
				{
					User user = userDao.findAll().get(random.nextInt(userDao.findAll().size()));
					Course course = courseDao.findAll().get(random.nextInt(courseDao.findAll().size()));
					String eventType = eventTypes[random.nextInt(eventTypes.length)];
					Entry entry = new Entry("Classroom " + random.nextInt(100), eventType, result, LocalDate.now(), course, user);
					entryDao.save(entry);
				}
				for (int i = 0; i < 50;i++) 
				{
					User user = userDao.findAll().get(random.nextInt(userDao.findAll().size()));
					Course course = courseDao.findAll().get(random.nextInt(courseDao.findAll().size()));
					String eventType = eventTypes[random.nextInt(eventTypes.length)];
					Entry entry = new Entry("Zoom", eventType, result, LocalDate.now(), course, user);
					entryDao.save(entry);
				}
				logger.info("All entries are saved!");
				
			}
			
			
			if(commentDao.count() == 0 && entryDao.count() != 0) 
			{
				LocalDate date = LocalDate.of(2023, 12, 31);
				LocalTime time = LocalTime.of(21, 0); // 9:00 PM

				// Combine LocalDate and LocalTime to create LocalDateTime
				LocalDateTime dateTime = date.atTime(time);
				// Extract LocalDate from LocalDateTime
				LocalDate result = dateTime.toLocalDate();	
				
				Random random = new Random();
				for (int i = 0; i < 200;i++) 
				{
					User user = userDao.findAll().get(random.nextInt(userDao.findAll().size()));
					Entry entry = entryDao.findAll().get(random.nextInt(entryDao.findAll().size()));
					String str = "This is an example comment made by " + user.getName();
					Comment comment= new Comment(user, entry, str, result);
					commentDao.save(comment);
				}
				logger.info("All comments are saved!");
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
		
		@GetMapping("/{courseCode}/entry")
		public List <Entry> entryByCourseCode(@PathVariable("courseCode") String courseCode){
			return entryDao.findByCourse(courseDao.findByCode(courseCode));
		}
		
		@GetMapping("/{entryID}/details")
		public Entry getEntryByID(@PathVariable("entryID") String entryID) {
			return entryDao.findById(entryID).get();
		}
		
		@GetMapping("/{entryID}/comments")
		public List<Comment> getCommentOfEntry(@PathVariable("entryID") String entryID) {
			return commentDao.findByEntry(entryDao.findById(entryID).get());
		}
		
		@GetMapping("/{courseCode}")
		public Course getCoursebyCode(@PathVariable("courseCode") String courseCode) {
			return courseDao.findByCode(courseCode);
		}
		
		@GetMapping("/users/{name}")
		public User getUserbyName(@PathVariable("name") String name) {
			return userDao.findByName(name).get(0);
		}
		
		
}
