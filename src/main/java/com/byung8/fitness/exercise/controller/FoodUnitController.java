package com.byung8.fitness.exercise.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.byung8.common.domain.IResult;
import com.byung8.common.domain.Result;
import com.byung8.fitness.exercise.service.FoodUnitService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FoodUnitController {
	@Autowired
	private FoodUnitService foodUnitService;
	
	private String txId() {
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/food/all", method = RequestMethod.GET)
	public ResponseEntity<String> getAll() {

		String txid = txId();
		log.info(txid+",Begin to getAll");
		try {
			Result result = foodUnitService.getAll(txid);
			log.warn(txid+",OK to getAll,result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to fetch getAll,Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
	
	@RequestMapping(value = "/food/{typeId}/type", method = RequestMethod.GET)
	public ResponseEntity<String> getByTypeId(@PathVariable("typeId") final String typeId) {

		String txid = txId();
		log.info(txid+",Begin to getByTypeId,typeId="+typeId);
		try {
			Result result = foodUnitService.getByType(typeId, txid);
			log.warn(txid+",OK to getByTypeId,typeId="+typeId+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to fetch getByTypeId,typeId="+typeId+",Exeption", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
	
	@RequestMapping(value = "/food/{typeName}/typename", method = RequestMethod.GET)
	public ResponseEntity<String> getByTypeName(@PathVariable("typeName") final String typeName) {

		String txid = txId();
		log.info(txid+",Begin to getByTypeName,typeName="+typeName);
		try {
			Result result = foodUnitService.getByTypeName(typeName, txid);
			log.warn(txid+",OK to getByTypeName,typeName="+typeName+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to getByTypeName,typeName="+typeName+",Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
	
	@RequestMapping(value = "/food/{name}/name", method = RequestMethod.GET)
	public ResponseEntity<String> getByName(@PathVariable("name") final String name) {

		String txid = txId();
		log.info(txid+",Begin to getByName,name="+name);
		try {
			Result result = foodUnitService.getByName(name, txid);
			log.warn(txid+",OK to getByName,name="+name+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to getByName,name="+name+",Exeption", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
	
	@RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getFoodUnit(@PathVariable("id") final String id) {

		String txid = txId();
		log.info(txid+",Begin to getFoodUnit,id="+id);
		try {
			Result result = foodUnitService.getFoodUnit(id, txid);
			log.warn(txid+",OK to getFoodUnit,id="+id+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to getFoodUnit,id="+id+",Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
}
