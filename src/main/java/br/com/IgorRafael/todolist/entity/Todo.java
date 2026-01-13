package br.com.IgorRafael.todolist.entity;

import br.com.IgorRafael.todolist.entity.Enum.Prioridade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todo")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String nome;
	
    @NotBlank
	private String descricao;
	private boolean realizado;
	private Prioridade prioridade;
	
	public Todo() {
	}
	
	public Todo(Integer id, @NotBlank String nome, @NotBlank String descricao, boolean realizado, Prioridade prioridade) {
		this.id = id;
		this.nome = nome;
	    this.descricao = descricao;
	    this.realizado = realizado;
	    this.prioridade = prioridade;
		
	}
	
	public Todo(String nome, String descricao, boolean realizado, Prioridade prioridade) {
		this.nome = nome;
	    this.descricao = descricao;
	    this.realizado = realizado;
	    this.prioridade = prioridade;
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isRealizado() {
		return realizado;
	}
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
	
	
	
}
