package com.mathexample.mathapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({"com.mathexample.mathapi"})
public class MathapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MathapiApplication.class, args);
	}

}
