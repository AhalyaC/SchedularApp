package com.scheduler.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.scheduler.springboot.model.User;
import com.scheduler.springboot.repository.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userdao;
	
	Logger log = LoggerFactory.getLogger(UserService.class);

	@Scheduled(fixedRate=5000)
	public void addJob() {
		User user = new User();
		user.setUserName("user"+new Random().nextInt(374483));
		userdao.save(user);
		System.out.println("add in" + new Date().toString());
	}
	
	@Scheduled(cron="0/15 * * * * * ")

	public void getJob() {
		
		List<User> user = userdao.findAll();
		System.out.println("fetch in" + new Date().toString());
		System.out.println("Number of records" + user.size());

		log.info("user :{} ",user);
	}
}
