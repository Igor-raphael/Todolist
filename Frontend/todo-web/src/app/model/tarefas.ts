
export type Prioridade = 'BAIXA' | 'MEDIA' | 'ALTA';

export interface Tarefas {

  id : number;
  nome : string;
  descricao: string;
  realizado: boolean;
  prioridade: Prioridade;


}
