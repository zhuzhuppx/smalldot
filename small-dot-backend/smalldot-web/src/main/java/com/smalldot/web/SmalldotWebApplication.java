package com.smalldot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.smalldot")
public class SmalldotWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmalldotWebApplication.class, args);
	}

}
