package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ServerDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerDbApplication.class, args);
		System.out.println("Good to move");
	}

}