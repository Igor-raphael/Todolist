package br.com.IgorRafael.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.repository.TodoRepository;

@Service
public class CreateService {
	
private final TodoRepository todoRepository;
	
	public CreateService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Autowired
	private ListService listService;
	
	
	public List<Todo> create(Todo todo) {
		todoRepository.save(todo);
		return listService.list();
		
	}
	
}
