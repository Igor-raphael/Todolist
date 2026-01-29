export type Prioridade = 'BAIXA' | 'MEDIA' | 'ALTA';

export interface TarefaDTO{
  nome: string;
  descricao: string;
  realizado: boolean;
  prioridade: Prioridade;
}
