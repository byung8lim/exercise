package com.byung8.fitness.exercise.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.byung8.fitness.domain.FoodUnit;

@Mapper
public interface FoodUnitMapper {
	List<FoodUnit> findByType(String typeId) throws SQLException;
	List<FoodUnit> findByTypeName(String name) throws SQLException;
	List<FoodUnit> findByName(String name) throws SQLException;
	List<FoodUnit> findAll() throws SQLException;
	FoodUnit findFoodUnit(String id) throws SQLException;
}
