package br.com.IgorRafael.todolist.service;

import org.springframework.stereotype.Component;

import br.com.IgorRafael.todolist.repository.TodoRepository;

@Component
public class DBAtivo {
	
	//Classe criada para manter o postgreSQL que esta no Render.
	
	private final TodoRepository repository;
	
	public DBAtivo(TodoRepository repository) {
		this.repository = repository;
	}
	
   public void dbAtivo(){
    	repository.ping();
    }

}
