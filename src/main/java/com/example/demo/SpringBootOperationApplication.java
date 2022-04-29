package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({"com.example.controller","com.example.service","com.example.implementation"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class SpringBootOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOperationApplication.class, args);
	}

}
