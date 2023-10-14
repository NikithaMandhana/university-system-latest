package com.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.university")
//@OpenAPIDefinition(info = @Info(title = "University API", version = "2.0", description = "University Information"))
public class UniversitySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversitySystemApplication.class, args);
	}
}
