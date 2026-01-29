import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DeleteService {

  constructor(private httpClient: HttpClient) { }

  private readonly API = '/todos';

  delete(id: number){

    return this.httpClient.delete<void>(`${this.API}/${id}`);

  }

}
