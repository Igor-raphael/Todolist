package br.com.IgorRafael.todolist.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.IgorRafael.todolist.entity.Todo;


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
	
	public List<Todo> listTodo(String clientID){
		return listService.list(clientID);
	}
	
	public Todo create(String clientID, Todo todo){
		return createService.create( clientID, todo);
	}
		
	public Todo update (String clientID, Integer id, Todo todo) {
		return updateService.update(clientID, id, todo);
	}
	
	public void checkUpdate(String clientID, Integer id, boolean realizado ) {
		updateService.check(clientID, id, realizado);
	}
	
	public void delete(String clientID, Integer id){
		 deleteService.delete(clientID, id);
	}
	
	

}
