package br.com.IgorRafael.todolist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.IgorRafael.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	List<Todo> findByClientID(String clientId, Sort sort);
	
	Optional<Todo> findByClientIDAndId(String clientID, Integer id);
	
}
