package com.devtypes.retrospec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.devtypes.retrospec")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
