package com.byung8.fitness.exercise;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ExerciseErrorListener
 *
 */
@Slf4j
public class ExerciseErrorListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
       if (event.getException() != null) {
    	   event.getApplicationContext().close();    	   
    	   System.exit(-1);
       } 
    }
}
