import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarefas } from '../../model/tarefas';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {

  constructor(private httpClient: HttpClient) { }

  private readonly API = "/todos";

  update(id: number, tarefas: Tarefas){

   return this.httpClient.put<Tarefas>(`${this.API}/${id}`, tarefas);

  }
}
