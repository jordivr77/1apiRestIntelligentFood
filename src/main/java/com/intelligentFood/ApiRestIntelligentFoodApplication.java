package com.intelligentFood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.intelligentFood.repository")
public class ApiRestIntelligentFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestIntelligentFoodApplication.class, args);
	}

}
