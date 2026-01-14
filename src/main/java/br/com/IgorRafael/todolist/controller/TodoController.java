package br.com.IgorRafael.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@Autowired
	private TodoServiceCentral todoService;
	
	
	@Operation(summary = "Cria tarefa")
	@PostMapping(path = "/create")
	@ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso.")
	Todo create(@Valid @RequestBody Todo todo){
		return todoService.create(todo);
	}	 
	
	
	@Operation(summary = "Lista todas as terafas disponíveis.")
	@GetMapping
	List<Todo> list(){
		return todoService.listTodo() ;
	}
	

	@Operation(summary = "Altera a tarefa selecionada.")
	@PutMapping(path ="/{id}")
    Todo update(@PathVariable("id") Integer id, @RequestBody Todo todo){
    	return todoService.update(id, todo);
    }
	
	
	@Operation(summary = "Deleta a tarefa selecionada.")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
	   todoService.delete(id);
    }
    
}
