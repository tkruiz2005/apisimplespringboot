package com.personajes.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class PersonajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonajesApplication.class, args);
	}

}
