package br.com.IgorRafael.todolist.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.entity.Enum.Prioridade;
import br.com.IgorRafael.todolist.repository.TodoRepository;
import br.com.IgorRafael.todolist.service.ListService;

@ExtendWith(MockitoExtension.class)
public class ListServiceTest {
	
	@Mock
	TodoRepository repository;
	
	@InjectMocks
	ListService listService;
	
	Todo todo, todo1 ,todo2;
	String clientID = "C01";
	String clientID2 = "C02";
	
	
	@BeforeEach
	void SetUp() {
		
		todo = new Todo();
		todo1 = new Todo();
		todo2 = new Todo();
		
		todo.setClientID(clientID);
		todo.setNome("Concluir Pokemon Esmerald");
		todo.setDescricao("Nostalgia.");
		todo.setRealizado(false);
		todo.setPrioridade(Prioridade.ALTA);
		
		todo1.setClientID(clientID);
		todo1.setNome("Concluir Pokemon Y");
		todo1.setDescricao("80%");
		todo1.setRealizado(true);
		todo1.setPrioridade(Prioridade.BAIXA);
		
		todo2.setClientID(clientID2);
		todo2.setNome("Concluir Pokemon Sun");
		todo2.setDescricao("20%");
		todo2.setRealizado(true);
		todo2.setPrioridade(Prioridade.MEDIA);
		
	}
	
	@Test
	@DisplayName("Teste de listamento de tarefas.")
	void ListServiceSucess() {
		
		List<Todo> tarefas = List.of(
				
				todo,
				todo1
		);
		
		
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending()).and(Sort.by("realizado").ascending());

		
		when(repository.findByClientID("C01", sort)).thenReturn(tarefas);
		
		List<Todo> result = listService.list("C01");
		
		
		assertNotNull(result);
		assertEquals(2, result.size());

		// Primeiro elemento
		assertEquals("C01", result.get(0).getClientID());
		assertEquals("Concluir Pokemon Esmerald", result.get(0).getNome());
		assertEquals("Nostalgia.", result.get(0).getDescricao());
		assertFalse(result.get(0).isRealizado());
		assertEquals(Prioridade.ALTA, result.get(0).getPrioridade());

		// Segundo elemento
		assertEquals("C01", result.get(1).getClientID());
		assertEquals("Concluir Pokemon Y", result.get(1).getNome());
		assertEquals("80%", result.get(1).getDescricao());
		assertTrue(result.get(1).isRealizado());
		assertEquals(Prioridade.BAIXA, result.get(1).getPrioridade());

		
		verify(repository, times(1)).findByClientID("C01", sort);
		
		
	}
	
	
	

}
