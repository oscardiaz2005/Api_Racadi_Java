package com.Racadi.Academy.Racadi_Academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RacadiAcademyApplication {
	public static void main(String[] args) {
		SpringApplication.run(RacadiAcademyApplication.class, args);
	}
}
