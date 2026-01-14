package br.com.IgorRafael.todolist.entity.Enum;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Prioridade da tarefa.")
public enum Prioridade {
	
	@Schema(description = "Baixa prioridade")
	BAIXA("Baixa"),
	
	@Schema(description = "Prioridade média")
	MEDIA("Média"),
	
	@Schema(description = "Alta prioridade")
	ALTA("Alta");
	
	private final String descricao;
	
	Prioridade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

}
