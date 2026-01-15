package br.com.IgorRafael.todolist.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.entity.Enum.Prioridade;
import br.com.IgorRafael.todolist.repository.TodoRepository;
import br.com.IgorRafael.todolist.service.CreateService;

@ExtendWith(MockitoExtension.class)
public class CreateServiceTest {
	
	@Mock
	TodoRepository repository;
	
	@InjectMocks
	CreateService createService;
	
	Todo todo;
	
	@BeforeEach
	 void SetUp() {
		
		todo = new Todo();
		
		todo.setNome("Concluir Pokemon Esmerald");
		todo.setDescricao("Nostalgia.");
		todo.setRealizado(false);
		todo.setPrioridade(Prioridade.MEDIA);
		
	}
	
	
	@Test
	@DisplayName("Teste de criação de tarefa.")
	void createTaskSucess() {
		
		when(repository.save(todo)).thenReturn(todo);
		
		Todo result = createService.create(todo);
		
		
		assertNotNull(result);
		assertEquals("Concluir Pokemon Esmerald", result.getNome());
		assertEquals("Nostalgia.", result.getDescricao());
		assertEquals(false, result.isRealizado());
		assertEquals(Prioridade.MEDIA, result.getPrioridade());
		
		verify(repository, times(1)).save(todo);
		
		
	}
	
	
	

}
