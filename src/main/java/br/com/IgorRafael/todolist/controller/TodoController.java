package br.com.IgorRafael.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.service.TodoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	
	@PostMapping(path = "/{nome}/{descricao}/{realizado}/{prioridade}")
	List<Todo> create(@Valid 
		@PathVariable(name = "nome") String nome,
		@PathVariable(name = "descricao") String descricao, 
		@PathVariable(name = "realizado") boolean realizado,
		@PathVariable(name = "prioridade") int prioridade) {
		Todo todo = new Todo(nome, descricao, realizado, prioridade);
		return todoService.create(todo);
		
	}	 
	
	
	@GetMapping
	List<Todo> list(){
		return todoService.list();
	}
	
	
	@PutMapping(path ="/{id}")
    List<Todo> update(@PathVariable("id") Long id, @RequestBody Todo todo){
    	return todoService.update(id, todo);
    }
	
    @DeleteMapping(path = "/{id}")
    List<Todo> delete(@PathVariable("id") Long id){
	   return todoService.delete(id);
    }
    
}
