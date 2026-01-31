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
	
	public List<Todo> listTodo(){
		return listService.list();
	}
	
	public Todo create(Todo todo){
		return createService.create(todo);
	}
		
	public Todo update (Integer id, Todo todo) {
		return updateService.update(id, todo);
	}
	
	public void checkUpdate(Integer id, boolean realizado ) {
		updateService.check(id, realizado);
	}
	
	public void delete(Integer id){
		 deleteService.delete(id);
	}
	
	

}
