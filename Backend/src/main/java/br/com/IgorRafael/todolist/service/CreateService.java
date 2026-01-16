package br.com.IgorRafael.todolist.service;

import org.springframework.stereotype.Service;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.repository.TodoRepository;

@Service
public class CreateService {
	
private final TodoRepository todoRepository;
	
	public CreateService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public Todo create(Todo todo) {
		todoRepository.save(todo);
		return todo;
		
	}
	
}
