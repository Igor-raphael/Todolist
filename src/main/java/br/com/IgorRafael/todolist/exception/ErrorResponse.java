package br.com.IgorRafael.todolist.exception;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name = "ErrorResponse", description = "Estrutura padrão de erro da API.")
public class ErrorResponse {
	
	@Schema(
	        description = "Código de status HTTP retornado."
	    )
	    private int status;

	    @Schema(
	        description = "Nome do erro HTTP."
	    )
	    private String error;

	    @Schema(
	        description = "Mensagem descritiva do erro."
	    )
	    private String message;
	
	
	public ErrorResponse(int status, String error, String message) {
	
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}
	
	

}
