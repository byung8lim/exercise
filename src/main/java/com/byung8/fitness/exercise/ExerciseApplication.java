package com.byung8.fitness.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EntityScan
@Configuration
@SpringBootApplication
public class ExerciseApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EvthookApplication.class, args);
		System.out.println( "==== Spring Boot Web Application ====" );
		SpringApplication app = new SpringApplication(ExerciseApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}

}
