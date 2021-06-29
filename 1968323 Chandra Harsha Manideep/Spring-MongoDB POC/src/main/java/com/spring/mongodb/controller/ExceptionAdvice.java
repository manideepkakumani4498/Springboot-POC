package com.spring.mongodb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.custom.Exception.ServiceException;
import com.spring.mongodb.model.CellListError;

@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<CellListError> mapexception(ServiceException se){
		CellListError ce=new CellListError(HttpStatus.INTERNAL_SERVER_ERROR.value(),se.getMessage());
		return new ResponseEntity<CellListError>(ce,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
