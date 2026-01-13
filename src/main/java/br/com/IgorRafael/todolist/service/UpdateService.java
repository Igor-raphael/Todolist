package br.com.IgorRafael.todolist.service;

import org.springframework.stereotype.Service;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.exception.BadRequestException;
import br.com.IgorRafael.todolist.repository.TodoRepository;

@Service
public class UpdateService {

	private final TodoRepository todoRepository;
	
	public UpdateService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	
		public Todo update(Integer id, Todo todo){
		
		todoRepository.findById(id).ifPresentOrElse(ExisteOTodo -> {
			todo.setId(id);
			todoRepository.save(todo);
			
		}, () -> {
			
			throw new BadRequestException("Todo %d não existe! ".formatted(id));
			 
		});
		
		return todo;
	}
	
}
