package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories("com.example.java.repository")

public class JavaWebApp {

	public static void main(String[] args) {
		SpringApplication.run(JavaWebApp.class, args);
	}

}
