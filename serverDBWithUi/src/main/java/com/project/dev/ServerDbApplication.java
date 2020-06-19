package com.project.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableJpaAuditing
public class ServerDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerDbApplication.class, args);
		System.out.println("Good to move");
	}

	@Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}