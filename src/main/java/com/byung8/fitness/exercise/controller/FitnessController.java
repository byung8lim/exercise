package com.byung8.fitness.exercise.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.byung8.common.domain.IResult;
import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.fitness.domain.ExerciseAmount;
import com.byung8.fitness.exercise.service.ExerciseService;

import lombok.extern.slf4j.Slf4j;

/**
 * RestServiceController class
 * 
 * @author 06919
 *
 */
@RestController
@Slf4j
@RequestMapping(value = "/exec")
public class FitnessController {

	@Autowired
	ExerciseService exerciseService;
	
	private String txId() {
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/calorie", method = RequestMethod.POST)
	public ResponseEntity<String> calculateCalorie(@RequestBody final ExerciseAmount amount) {

		String txid = txId();
		log.info(txid+",Begin to calculateCalorie,amount={"+amount+"}");
		try {
			Result result = exerciseService.calculateCalorie(amount, txid);
			log.warn(txid+",OK to calculateCalorie,amount={"+amount+"},result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to calculateCalorie,amount={"+amount+"},Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
	
	@RequestMapping(value = "/unit/all", method = RequestMethod.GET)
	public ResponseEntity<String> getAll() {

		String txid = txId();
		log.info(txid+",Begin to getAll");
		try {
			Result result = exerciseService.findAll(txid);
			log.warn(txid+",OK to getAll, result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to getAll, Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/unit/{exerciseId}", method = RequestMethod.GET)
	public ResponseEntity<String> getExerciseUnit(@PathVariable("exerciseId") final String exerciseId) {

		String txid = txId();
		log.info(txid+",Begin to getExerciseUnit,exerciseId="+exerciseId);
		try {
			Result result = exerciseService.findExerciseUnit(exerciseId, txid);
			log.warn(txid+",OK to getExerciseUnit,exerciseId="+exerciseId+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to getExerciseUnit, iexerciseId="+exerciseId+",Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/unit/{typeId}/type", method = RequestMethod.GET)
	public ResponseEntity<String> getByType(@PathVariable("typeId") final String typeId) {

		String txid = txId();
		log.info(txid+",Begin to getByType,typeId="+typeId);
		try {
			Result result = exerciseService.findByType(typeId, txid);
			log.warn(txid+",OK to getByType,typeId="+typeId+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error(txid+",OK to getByType,typeId="+typeId+",Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/unit/{typeName}/typename", method = RequestMethod.GET)
	public ResponseEntity<String> getByTypeName(@PathVariable("typeName") final String typeName) {

		String txid = txId();
		log.info(txid+",Begin to getByTypeName,typeName="+typeName);
		try {
			Result result = exerciseService.findByTypeName(typeName, txid);
			log.warn(txid+",OK to getByTypeName,typeName="+typeName+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.warn(txid+",Failed to getByTypeName,typeName="+typeName+",Exception",e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/unit/{name}/name", method = RequestMethod.GET)
	public ResponseEntity<String> getByName(@PathVariable("name") final String name) {

		String txid = txId();
		log.info(txid+",Begin to getByName,name="+name);
		try {
			Result result = exerciseService.findByName(name, txid);
			log.warn(txid+",OK to getByName,name="+name+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to getByName,name="+name+",Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
}
