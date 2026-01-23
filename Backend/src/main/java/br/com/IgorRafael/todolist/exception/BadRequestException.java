package br.com.IgorRafael.todolist.exception;


public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BadRequestException(String messagem) {
		super(messagem);
	}

}
