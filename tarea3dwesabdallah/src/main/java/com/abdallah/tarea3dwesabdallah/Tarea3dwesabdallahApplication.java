package com.abdallah.tarea3dwesabdallah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tarea3dwesabdallahApplication {
	
	@Bean
	public Principal applicationStartupRunner() {
		return new Principal();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Tarea3dwesabdallahApplication.class, args);
	}
	
	

}
