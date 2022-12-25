package com.byung8.fitness.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExerciseCalorie {
	private String execiseName;
	private float execiseAmount;
	private float unitCalorie;
	private String amtUnitName;
	private String formula;
	private float totalCalorie;
}
