import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CreateService {

  //private readonly API = 'http://localhost:8080/todos/create';

  private readonly API = '/assets/test.json';

  constructor(private httpClient: HttpClient) { }


}
