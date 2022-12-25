package com.byung8.fitness.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExerciseAmount {
	private String id;
	private String name;
	private float weight;
	private float amount;
}
