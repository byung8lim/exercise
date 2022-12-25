package com.byung8.fitness.exercise.service;

import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.fitness.domain.ExerciseAmount;

public interface ExerciseService {
	Result calculateCalorie(ExerciseAmount amount, String txid) throws Byung8Exception;
	Result findExerciseUnit(String exerciseId, String txid) throws Byung8Exception;
	Result findByType(String typeId, String txid) throws Byung8Exception;
	Result findByTypeName(String typeName, String txid) throws Byung8Exception;
	Result findByName(String typeName, String txid) throws Byung8Exception;
	Result findAll(String txid) throws Byung8Exception;
}
