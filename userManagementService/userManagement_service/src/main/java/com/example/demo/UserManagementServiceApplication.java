package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;


//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableEurekaClient
public class UserManagementServiceApplication {
	
//	@Autowired
//	private UserRepository userRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
		
		
		
		
	}

}
