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
		
		Todo Existe = todoRepository.findById(id).orElseThrow(() -> new BadRequestException("A tarefa de número: %d, não existe! ".formatted(id)));
			
			Existe.setNome(todo.getNome());
			Existe.setDescricao(todo.getDescricao());
			Existe.setRealizado(todo.isRealizado());
			Existe.setPrioridade(todo.getPrioridade());
			
			return todoRepository.save(Existe);
		
	}
	
}
