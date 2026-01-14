package br.com.IgorRafael.todolist.service;

import org.springframework.stereotype.Service;

import br.com.IgorRafael.todolist.exception.BadRequestException;
import br.com.IgorRafael.todolist.repository.TodoRepository;

@Service
public class DeleteService {
	
	private final TodoRepository todoRepository;
	
	public DeleteService( TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	
	public void delete(Integer id) {
		
		todoRepository.findById(id).ifPresentOrElse(ExisteOTodo -> {
			todoRepository.delete(ExisteOTodo);
			
		}, () -> {
			
			throw new BadRequestException("A tarefa de número: %d, não pode ser excluída pois ela não existe!".formatted(id));
			 
		});
	
	}

}
