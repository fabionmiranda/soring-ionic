package com.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.services.exception.NotFoundException;


//Handler sao manipuladores de excecoes. em vez de ficar usando try catch;
@ControllerAdvice
public class ControllerExceptionHandler {
	
	//metodo para tratar excecoes com Handler.
	//classe padrão do ControllerAdvise
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErroPadrao> ObjetoHandlerNotFound (NotFoundException e, HttpServerErrorException request){
		
		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	

}
