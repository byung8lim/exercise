package com.byung8.fitness.exercise.service;

import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;

public interface FoodUnitService {
	Result getFoodUnit(String unitId, String txid) throws Byung8Exception;
	Result getByType(String typeId, String txid) throws Byung8Exception;
	Result getByTypeName(String typeName, String txid) throws Byung8Exception;
	Result getByName(String name, String txid) throws Byung8Exception;
	Result getAll(String txid) throws Byung8Exception;
}
