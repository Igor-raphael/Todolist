package br.com.IgorRafael.todolist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.service.TodoServiceCentral;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
@Tag(name = "FlowList", description = "Endpoints para gerenciamento de tarefas.")

@ApiResponses({
	@ApiResponse(responseCode = "200", description = "Operação realizada com sucesso."),
	
	    @ApiResponse(responseCode = "400", description = "Dados inválidos.",
	        content = @Content(
	            mediaType = "application/json",
	            examples = @ExampleObject(
	                value = """
	                {
	                  "status": 400,
	                  "error": "Bad Request",
	                  "message": "Dados inválidos informados na requisição."
	                }
	                """
	            )
	        )
	    ),
	    
	    @ApiResponse(
	            responseCode = "409",
	            description = "Conflito (concorrência).",
	            content = @Content(
	                mediaType = "application/json",
	                examples = @ExampleObject(
	                    value = """
	                    {
	                      "status": 409,
	                      "error": "Conflict",
	                      "message": "Ocorreu um problema de concorrência."
	                    }
	                    """
	                )
	            )
	        ),

	    @ApiResponse(responseCode = "500", description = "Erro interno.",
	        content = @Content(
	            mediaType = "application/json",
	            examples = @ExampleObject(
	                value = """
	                {
	                  "status": 500,
	                  "error": "Internal Server Error",
	                  "message": "Ocorreu um erro inesperado."
	                }
	                """
	            )
	        )
	    )
	})

public class TodoController {

	
	private final TodoServiceCentral todoService;
	
	public TodoController(TodoServiceCentral serviceCentral) {
		this.todoService = serviceCentral;
		
	}
	
	
	@Operation(summary = "Cria tarefa")
	@PostMapping(path = "/create")
	Todo create(@RequestHeader("X-Client-Id") String clientID, @Valid @RequestBody Todo todo){
		return todoService.create(clientID, todo);
	}	 
	
	
	@Operation(summary = "Lista todas as terafas disponíveis.")
	@GetMapping
	
	List<Todo> list(@RequestHeader("X-Client-Id") String clientID){
		return todoService.listTodo(clientID) ;
	}
	

	@Operation(summary = "Altera a tarefa selecionada.")
	@PutMapping(path ="/{id}")
    Todo update(@RequestHeader("X-Client-Id") String clientID, @PathVariable("id") Integer id, @Valid @RequestBody Todo todo){
    	return todoService.update(clientID, id, todo);
    }
	
	
	@Operation(summary = "Altera a conclusão da tarefa selecionada.")
	@PutMapping(path = "/{id}/realizado")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void updateCheck(@RequestHeader("X-Client-Id") String clientID , @PathVariable("id") Integer id, @RequestBody Map<String, Boolean> body) {
		
		todoService.checkUpdate(clientID, id, body.get("realizado"));
		
	}
	
	
	@Operation(summary = "Deleta a tarefa selecionada.")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestHeader("X-Client-Id") String clientID,  @PathVariable("id") Integer id){
	   todoService.delete(clientID, id);
    }
    
}
