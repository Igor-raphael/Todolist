package br.com.IgorRafael.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.exception.BadRequestException;
import br.com.IgorRafael.todolist.repository.TodoRepository;

@Service
public class TodoService {
	
	private TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	
	public List<Todo> list(){
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		return todoRepository.findAll(sort);
	}
	

	public List<Todo> create(Todo todo) {
		todoRepository.save(todo);
		return list();
		
	}
	
	public List<Todo> update(Long id, Todo todo){
		
		todoRepository.findById(id).ifPresentOrElse(ExisteOTodo -> {
			todo.setId(id);
			todoRepository.save(todo);
			
		}, () -> {
			
			throw new BadRequestException("Todo %d não existe! ".formatted(id));
			 
		});
		
		return list();
	}
	
	
	
	
	public List<Todo> delete(long id) {
		
		todoRepository.findById(id).ifPresentOrElse(ExisteOTodo -> {
			todoRepository.delete(ExisteOTodo);
			
		}, () -> {
			
			throw new BadRequestException("Todo %d não existe! ".formatted(id));
			 
		});
		
		return list();
	
	}
	

}
