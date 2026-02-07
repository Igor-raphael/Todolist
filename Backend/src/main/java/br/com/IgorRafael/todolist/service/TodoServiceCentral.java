package br.com.IgorRafael.todolist.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.exception.BadRequestException;

@Component
public class TodoServiceCentral {
	
	private final ListService listService;
	private final CreateService createService;
	private final UpdateService updateService;
	private final DeleteService deleteService;
	
	public TodoServiceCentral(ListService listService, CreateService createService, UpdateService updateService, DeleteService deleteService) {
		this.listService = listService;
		this.createService = createService;
		this.updateService = updateService;
		this.deleteService = deleteService;
	}
	
	private void validateClientId(String clientID) {
		if (clientID == null || clientID.isBlank()) {
			   throw new BadRequestException("X-Client-Id obrigatório");
			}
	}
	
	public List<Todo> listTodo(String clientID){
		validateClientId(clientID);
		return listService.list(clientID);
	}
	
	public Todo create(String clientID, Todo todo){
		validateClientId(clientID);
		return createService.create( clientID, todo);
	}
		
	public Todo update (String clientID, Integer id, Todo todo) {
		validateClientId(clientID);
		return updateService.update(clientID, id, todo);
	}
	
	public void checkUpdate(String clientID, Integer id, boolean realizado ) {
		validateClientId(clientID);
		updateService.check(clientID, id, realizado);
	}
	
	public void delete(String clientID, Integer id){
		validateClientId(clientID);
		 deleteService.delete(clientID, id);
	}
	
	

}
