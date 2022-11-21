package com.project.matchday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.project.matchday")
public class MatchdayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchdayApplication.class, args);
	}

}
