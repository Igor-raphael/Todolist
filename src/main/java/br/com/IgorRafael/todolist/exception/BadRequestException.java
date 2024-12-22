package br.com.IgorRafael.todolist.exception;


//criei uma nova excepcao para tratar os erros de não achar o ID
public class BadRequestException extends RuntimeException {
	
	public BadRequestException(String messagem) {
		super(messagem);
	}

}
