package com.signet.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.signet.repository")
@ComponentScan(basePackages = "com.signet.*")
@EntityScan("com.signet.*")
public class SignetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignetApplication.class, args);
	}
}
