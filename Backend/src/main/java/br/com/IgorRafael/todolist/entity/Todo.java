package br.com.IgorRafael.todolist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.IgorRafael.todolist.entity.Enum.Prioridade;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "todo")
public class Todo {
	
	
	@Column(nullable = false, name = "clientid", length = 36)
	private String clientID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Schema(hidden = true)
	private Integer id;
	
	@Schema(description = "Nome da Tarefa.", example = "Estudar Docker.")
	@NotBlank
	private String nome;
	
	@Schema(description = "Descrição da Tarefa.", example = "Começar pelo básico.")
	private String descricao;
    
	@Schema(description = "Indica se a tarefa foi concluida.", example = "true")
    @NotNull
	private Boolean realizado;
    
	@Schema(description = "Prioridade da Tarefa.", example = "ALTA")
    @NotNull
	private Prioridade prioridade;
	
	public Todo() {
	}
	
	public Todo(Integer id, @NotBlank String nome, String descricao, boolean realizado, Prioridade prioridade) {
		this.id = id;
		this.nome = nome;
	    this.descricao = descricao;
	    this.realizado = realizado;
	    this.prioridade = prioridade;
		
	}
	
	public Todo(@NotBlank String nome, String descricao, boolean realizado, Prioridade prioridade) {
		this.nome = nome;
	    this.descricao = descricao;
	    this.realizado = realizado;
	    this.prioridade = prioridade;
		
	}
	
	public Todo(@NotBlank String nome, String descricao, Prioridade prioridade) {
		this.nome = nome;
	    this.descricao = descricao;
	    this.prioridade = prioridade;
		
	}
	
	
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientID() {
		return clientID;
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
