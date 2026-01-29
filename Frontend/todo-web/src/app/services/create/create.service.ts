import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarefas } from '../../model/tarefas';
import { TarefaDTO } from '../../model/TarefaDTO';

@Injectable({
  providedIn: 'root'
})
export class CreateService {

  private readonly API = '/create';

  constructor(private httpClient: HttpClient) { }

  create(payload: TarefaDTO){
    return this.httpClient.post(this.API, payload);
  }

}
