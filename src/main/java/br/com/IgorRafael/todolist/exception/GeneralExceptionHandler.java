package br.com.IgorRafael.todolist.exception;

import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GeneralExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	private ResponseEntity<String> handleBadRequest(BadRequestException exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}
	
	@ExceptionHandler(OptimisticEntityLockException.class)
	private ResponseEntity<Object> handleOptimisticEntityLockException(OptimisticEntityLockException exception){
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Ocorreu um problema de concorrência.");
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<String> handleGeneralException(Exception ex){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao criar o Todo.");
	}
	
}
