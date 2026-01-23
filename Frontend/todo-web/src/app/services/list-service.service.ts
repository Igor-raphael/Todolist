import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarefas } from '../model/tarefas';

@Injectable({
  providedIn: 'root'
})
export class ListServiceService {

  //private readonly API = 'http://localhost:8080/todos';

  private readonly API = 'assets/test.json';

  constructor(private httpClient: HttpClient) {}

list(){
    return this.httpClient.get<Tarefas[]>(this.API);
  }

}
