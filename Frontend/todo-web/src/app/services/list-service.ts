import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarefas } from '../model/tarefas';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  //private readonly API = 'http://localhost:8080/todos';

  private readonly API = '/assets/test.json';

  constructor(private httpClient: HttpClient) {}

list(): Observable<Tarefas[]>{
    return this.httpClient.get<Tarefas[]>(this.API);
  }

}
