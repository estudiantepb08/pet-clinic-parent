package com.pet.clinic.operador.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

	 @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	 public ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {
	     ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(),ex.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.value());
	      return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}