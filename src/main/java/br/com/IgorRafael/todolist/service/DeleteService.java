package br.com.IgorRafael.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.exception.BadRequestException;
import br.com.IgorRafael.todolist.repository.TodoRepository;

@Service
public class DeleteService {
	
	private final TodoRepository todoRepository;
	
	public DeleteService( TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	@Autowired 
	private ListService listService;
	
	
	public List<Todo> delete(Integer id) {
		
		todoRepository.findById(id).ifPresentOrElse(ExisteOTodo -> {
			todoRepository.delete(ExisteOTodo);
			
		}, () -> {
			
			throw new BadRequestException("Todo %d não existe! ".formatted(id));
			 
		});
		
		return listService.list();
	
	}

}
