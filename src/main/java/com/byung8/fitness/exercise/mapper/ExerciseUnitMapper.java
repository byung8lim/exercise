package com.byung8.fitness.exercise.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.byung8.fitness.domain.ExerciseUnit;

@Mapper
public interface ExerciseUnitMapper {
	ExerciseUnit findExerciseUnit(String exerciseUnitId) throws SQLException;
	List<ExerciseUnit> findByTypeName(String typeName) throws SQLException;
	List<ExerciseUnit> findByType(String typeId) throws SQLException;
	List<ExerciseUnit> findByName(String name) throws SQLException;
	List<ExerciseUnit> findAll() throws SQLException;
}
