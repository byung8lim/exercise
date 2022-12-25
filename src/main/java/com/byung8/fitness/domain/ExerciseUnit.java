package com.byung8.fitness.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExerciseUnit {
	private String exerciseId;
	private String exerciseEngName;
	private String exerciseName;
	private String description;
	private float unitCalorie;
	private String amtUnitId;
	private String amtUnitName;
	private String useYn;
	private Date regDate;
	private Date udpDate;
}
