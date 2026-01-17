package br.com.IgorRafael.todolist.services;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.entity.Enum.Prioridade;
import br.com.IgorRafael.todolist.repository.TodoRepository;
import br.com.IgorRafael.todolist.service.UpdateService;

@ExtendWith(MockitoExtension.class)
public class UpdateServiceTest {

	
	@Mock
	TodoRepository todoRepository;
		
	@InjectMocks
	UpdateService updateService;
	
	@Test
	@DisplayName("Test de alteração de tarefa com sucesso.")
	void UpdateServiceTestSucess() {
		
		Todo todo = new Todo();
		
		Todo newTodo = new Todo();
		
		todo.setNome("Concluir Pokemon Y");
		todo.setDescricao("80%");
		todo.setRealizado(false);
		todo.setPrioridade(Prioridade.BAIXA);
		
		Integer id = 1;
		
		newTodo.setNome("Concluir Pokemon Y");
		newTodo.setDescricao("100%");
		newTodo.setRealizado(true);
		newTodo.setPrioridade(Prioridade.BAIXA);
		
		when(todoRepository.findById(id)).thenReturn(Optional.of(todo));
		
		when(todoRepository.save(todo)).thenReturn(newTodo);
		
		Todo result = updateService.update(id, newTodo);
		
		
		assertEquals(newTodo.getNome(), result.getNome());
		assertEquals(newTodo.getDescricao(), result.getDescricao());
		assertEquals(newTodo.isRealizado(), result.isRealizado());
		assertEquals(newTodo.getPrioridade(), result.getPrioridade());
		
	}
	
	
}
