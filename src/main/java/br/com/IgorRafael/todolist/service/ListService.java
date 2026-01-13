package br.com.IgorRafael.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.repository.TodoRepository;

@Service
public class ListService {
	
private final TodoRepository todoRepository;
	
	public ListService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	
	public List<Todo> list(){
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		return todoRepository.findAll(sort);
	}
	

}
