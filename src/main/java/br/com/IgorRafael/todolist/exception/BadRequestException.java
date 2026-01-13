package br.com.IgorRafael.todolist.exception;


public class BadRequestException extends RuntimeException {
	
	public BadRequestException(String messagem) {
		super(messagem);
	}

}
