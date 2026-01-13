package br.com.IgorRafael.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.IgorRafael.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	

}
