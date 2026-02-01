import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarefas } from '../../model/tarefas';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  private readonly API = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

list(): Observable<Tarefas[]>{
  return this.httpClient.get<Tarefas[]>(this.API);
  }

}
