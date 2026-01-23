package br.com.IgorRafael.todolist.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.IgorRafael.todolist.entity.Todo;
import br.com.IgorRafael.todolist.entity.Enum.Prioridade;
import br.com.IgorRafael.todolist.exception.BadRequestException;
import br.com.IgorRafael.todolist.repository.TodoRepository;
import br.com.IgorRafael.todolist.service.DeleteService;


@ExtendWith(MockitoExtension.class)
public class DeleteServiceTest {
	
	@Mock
	TodoRepository todoRepository;
	
	@InjectMocks
	DeleteService deleteService;
	
	Todo todo, todo1 ,todo2;
	
	@BeforeEach
	void SetUp() {
		
		todo = new Todo();
		todo1 = new Todo();
		todo2 = new Todo();
		
		todo.setId(2);
		todo.setNome("Concluir Pokemon Esmerald");
		todo.setDescricao("Nostalgia.");
		todo.setRealizado(false);
		todo.setPrioridade(Prioridade.ALTA);
		
		todo1.setId(3);
		todo1.setNome("Concluir Pokemon Y");
		todo1.setDescricao("80%");
		todo1.setRealizado(false);
		todo1.setPrioridade(Prioridade.BAIXA);
		
		todo2.setId(1);
		todo2.setNome("Concluir Pokemon Sun");
		todo2.setDescricao("20%");
		todo2.setRealizado(false);
		todo2.setPrioridade(Prioridade.MEDIA);
		
	}



	@Test
	@DisplayName("Teste de Sucesso ao deletar uma tarefa.")
	void deleteServiceTestSucess(){
		
		Integer id = 3;
		
		List<Todo> tarefas = new ArrayList<>( List.of(
				
				todo,
				todo2,
				todo1
		));
		
		when(todoRepository.findById(id)).thenReturn(Optional.of(tarefas.get(2)));
		
		doAnswer(invocation -> {
			
			Todo todo = invocation.getArgument(0);
			
			tarefas.removeIf( t -> t.getId().equals(todo.getId()));
			
			return null;
			
		}).when(todoRepository).delete(any(Todo.class));
		
		deleteService.delete(id);
		
		assertEquals(2, tarefas.size());
		assertEquals("Concluir Pokemon Esmerald", tarefas.get(0).getNome());
		assertEquals("Concluir Pokemon Sun", tarefas.get(1).getNome());
		
		verify(todoRepository, times(1)).findById(id);
		verify(todoRepository, times(1)).delete(any(Todo.class));
	}
	
	
	@Test
	@DisplayName("Teste de falha ao deletar uma tarefa - A tarefa de número: ID, não pode ser excluída pois ela não existe!")
	void deleteServiceTestFailend() {
		
		Integer id = 3;
		
			List<Todo> tarefas = new ArrayList<>( List.of(
				
				todo,
				todo2,
				todo1
		));
			
			when(todoRepository.findById(id)).thenReturn(Optional.empty());
			
			BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
				
				deleteService.delete(id);
				
				
			});
			
			Assertions.assertEquals("A tarefa de número: %d, não pode ser excluída pois ela não existe!".formatted(id), thrown.getMessage());
			
			assertEquals(3, tarefas.size());
			verify(todoRepository, times(1)).findById(id);
		
	}
	
}