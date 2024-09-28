package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")// Enable @Controller, @Service, @Repositry
@EntityScan(basePackages = "com.entity")		// enable @Entity annotation 
@EnableJpaRepositories(basePackages = "com.repository")// enable spring jpa data features 
public class SbJpaDataRelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbJpaDataRelationshipApplication.class, args);
		System.err.println("spring boot with jpa data up!");
	}
}
