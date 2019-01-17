package com.ajs.seeonsite.seeonsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ajs.seeonsite.seeonsite.model.User;
import com.ajs.seeonsite.seeonsite.repository.UserRepository;

@SpringBootApplication
public class SeeonsiteApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	User user;

	public static void main(String[] args) {
		SpringApplication.run(SeeonsiteApplication.class, args);
	}

	@Bean
	public User getUser() {
		User user = new User();
		user.setEmail("asd@asd");
		user.setPassword("123asd");
		user.setUserName("asd");
		return user;
	}

	@Bean
	public void createUser() {
		System.out.println("created");
		userRepository.save(user);
	}

}
