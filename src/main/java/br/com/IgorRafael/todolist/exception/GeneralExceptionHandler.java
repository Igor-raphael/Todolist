package br.com.IgorRafael.todolist.exception;

import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GeneralExceptionHandler {

			@ExceptionHandler(BadRequestException.class)
			private ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException exception){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						
						new ErrorResponse(
								400, 
								HttpStatus.BAD_REQUEST.name(),
								exception.getMessage()
								));
			}
			
			@ExceptionHandler(OptimisticEntityLockException.class)
			private ResponseEntity<ErrorResponse> handleOptimisticEntityLockException(OptimisticEntityLockException exception){
				return ResponseEntity.status(HttpStatus.CONFLICT).body(
						
						new ErrorResponse(
								409,
								HttpStatus.CONFLICT.name(),
								"Ocorreu um problema de concorrência."
								));
			}
			
			@ExceptionHandler(Exception.class)
			private ResponseEntity<ErrorResponse> handleGeneralException(Exception ex){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
		
						new ErrorResponse(
								500, 
								HttpStatus.INTERNAL_SERVER_ERROR.name(),
								"Erro interno no servidor."
								));
			}
	
}
