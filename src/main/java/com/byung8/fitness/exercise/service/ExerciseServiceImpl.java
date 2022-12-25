package com.byung8.fitness.exercise.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.fitness.domain.ExerciseAmount;
import com.byung8.fitness.domain.ExerciseCalorie;
import com.byung8.fitness.domain.ExerciseUnit;
import com.byung8.fitness.exercise.mapper.ExerciseUnitMapper;

import lombok.extern.slf4j.Slf4j;

@Service("exerciseService")
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {
	@Autowired
	private ExerciseUnitMapper exerciseUnitMapper;
	
	@Override
	public Result calculateCalorie(ExerciseAmount amount, String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to calculateCalorie,amount={"+amount+"}");
		}
		try {
			ExerciseUnit unit = exerciseUnitMapper.findExerciseUnit(amount.getId());
			float cal = unit.getUnitCalorie() * amount.getWeight() * amount.getAmount();
			ExerciseCalorie calorie = new ExerciseCalorie();
			calorie.setExeciseName(unit.getExerciseName());
			calorie.setAmtUnitName(unit.getAmtUnitName());
			calorie.setUnitCalorie(unit.getUnitCalorie());
			calorie.setExeciseAmount(amount.getAmount());
			calorie.setTotalCalorie(cal);
			calorie.setFormula(String.valueOf(amount.getWeight())+"(weight) X "+String.valueOf(amount.getAmount())+"(Exercise Amount) X "+String.valueOf(unit.getUnitCalorie())+"(Unit Calorie)");
			result = new Result(txid, Result.OK).putValue("calorie", calorie);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to calculateCalorie,amount={"+amount+"},result={"+result+"+");
			}
		} catch(SQLException e) {
			log.error(txid+",Failed to calculateCalorie,amount={"+amount+"},Exeption", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findExerciseUnit(String exerciseId, String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to findExerciseUnit,exerciseId="+exerciseId);
		}
		try {
			ExerciseUnit unit = exerciseUnitMapper.findExerciseUnit(exerciseId);
			result = new Result(txid, Result.OK).putValue("ExerciseUnit", unit);
			if (log.isInfoEnabled()) {
				log.debug(txid+",OK to findExerciseUnit,exerciseId="+exerciseId+",result={"+result+"}");
			}
		} catch(SQLException e) {
			log.error(txid+",Failed to findExerciseUnit,exerciseId="+exerciseId+",Exeption", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findByType(String typeId, String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to findByType,typeId="+typeId);
		}
		try {
			List<ExerciseUnit> list = exerciseUnitMapper.findByType(typeId);
			result = new Result(txid, Result.OK).putValue("ListByType", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to findByType,typeId="+typeId+",result={"+result+"}");
			}
		} catch(SQLException e) {
			log.error(txid+",Failed to findByType,typeId="+typeId+",Exception");
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findByTypeName(String typeName, String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to findByTypeName,typeName="+typeName);
		}
		try {
			List<ExerciseUnit> list = exerciseUnitMapper.findByTypeName(typeName);
			result = new Result(txid, Result.OK).putValue("ListByTypeName", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to findByTypeName,typeName="+typeName);
			}
		} catch(SQLException e) {
			log.error(txid+",Failed to findByTypeName,typeName="+typeName+",Exception",e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findByName(String name, String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to findByName,name="+name);
		}
		try {
			List<ExerciseUnit> list = exerciseUnitMapper.findByName(name);
			result = new Result(txid, Result.OK).putValue("ListByName", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to findByName,name="+name+",result={"+result+"}");
			}
		} catch(SQLException e) {
			log.error("Failed to find ListByName,"+name+",Exception", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findAll(String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to findAll");
		}
		try {
			List<ExerciseUnit> list = exerciseUnitMapper.findAll();
			result = new Result(txid, Result.OK).putValue("AllList", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to findAll,result={"+result+"}");
			}
		} catch(SQLException e) {
			log.error(txid+",Failed to find findAll,Exception", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

}
