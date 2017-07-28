package com.example.springbootPostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootPostConstructApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostConstructApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	public @PostConstruct void init() {

		Arrays.asList("Simon", "Loomis", "Suiçmez")
				.forEach(u -> userRepository.save(new User(u)));

		userRepository.findAll().forEach(user -> System.out.println(user.getName()));
	}
}
