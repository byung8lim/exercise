package com.byung8.fitness.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.fitness.domain.FoodUnit;
import com.byung8.fitness.exercise.mapper.FoodUnitMapper;

import lombok.extern.slf4j.Slf4j;

@Service("foodUnitService")
@Slf4j
public class FoodUnitServiceImpl implements FoodUnitService {
	@Autowired
	private FoodUnitMapper foodUnitMapper;
	
	@Override
	public Result getFoodUnit(String unitId, String txid) throws Byung8Exception {
		Result result = null;
		StringBuilder sb = new StringBuilder();
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getFoodUnit,unitId="+unitId);
		}
		try {
			FoodUnit unit = foodUnitMapper.findFoodUnit(unitId);
			result = new Result(txid, Result.OK).putValue("FoodUnit", unit);
			if (log.isInfoEnabled()) {
				log.info(txid+",Begin to getFoodUnit,unitId="+unitId+",result={"+result+"}");
			}
		} catch (Exception e) {
			log.error(txid+",Failed to getFoodUnit,unitId="+unitId+",Exception",e);
			throw new Byung8Exception(sb.toString());
		}
		return result;
	}

	@Override
	public Result getByType(String typeId, String txid) throws Byung8Exception {
		Result result = null;
		StringBuilder sb = new StringBuilder();
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getByType,typeId="+typeId);
		}
		try {
			List<FoodUnit> list = foodUnitMapper.findByType(typeId);
			result = new Result(txid, Result.OK).putValue("ListByType", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to getByType,typeId="+typeId+",result={"+result+"}");
			}
		} catch (Exception e) {
			log.info(txid+",Failed to getByType,typeId="+typeId+",Exception",e);
			throw new Byung8Exception(sb.toString());
		}
		return result;
	}

	@Override
	public Result getByTypeName(String typeName, String txid) throws Byung8Exception {
		Result result = null;
		StringBuilder sb = new StringBuilder();
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getByTypeName,typeName="+typeName);
		}
		try {
			List<FoodUnit> list = foodUnitMapper.findByTypeName(typeName);
			result = new Result(txid, Result.OK).putValue("ListByTypeName", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to getByTypeName,typeName="+typeName+",result={"+result+"}");
			}
		} catch (Exception e) {
			log.error(txid+",Failed to getByTypeName,typeName="+typeName+",Exception",e);
			throw new Byung8Exception(sb.toString());
		}
		return result;
	}

	@Override
	public Result getByName(String name, String txid) throws Byung8Exception {
		Result result = null;
		StringBuilder sb = new StringBuilder();
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getByName,name="+name);
		}
		try {
			List<FoodUnit> list = foodUnitMapper.findByName(name);
			result = new Result(txid, Result.OK).putValue("ListByName", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to getByName,name="+name+",result={"+result+"}");
			}
		} catch (Exception e) {
			log.info(txid+",Failed to getByName,name="+name+",Exception",e);
			throw new Byung8Exception(sb.toString());
		}
		return result;
	}

	@Override
	public Result getAll(String txid) throws Byung8Exception {
		Result result = null;
		StringBuilder sb = new StringBuilder();
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getAll");
		}
		try {
			List<FoodUnit> list = foodUnitMapper.findAll();
			result = new Result(txid, Result.OK).putValue("AllList", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",Begin to getAll,result={"+result+"}");
			}
		} catch (Exception e) {
			log.error(txid+",OK to getAll,Exception",e);
			throw new Byung8Exception(sb.toString());
		}
		return result;
	}

}
