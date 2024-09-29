package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")	// enable @RestController, @Service, @Repository
@EntityScan(basePackages = "com.entity")			// enable @Entity annotation
public class SpringBootRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestapiApplication.class, args);
		System.out.println("Spring boot rest api up!");
	}

}
