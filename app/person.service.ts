import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from './person';

@Injectable({
  providedIn: 'root'
})

export class PersonService {

  private baseURL = "http://localhost:8080/person";
  private createURL = "http://localhost:8080/postPerson";
  private findPersonById = "http://localhost:8080/findPerson";
  private updatePersonById = "http://localhost:8080/putPerson";
  private deletePersonId = "http://localhost:8080/deletePerson";

  constructor(private httpClient: HttpClient) { }

  getPersonsList(): Observable<Person[]> {
    return this.httpClient.get<Person[]>(this.baseURL);
  }

  createPerson(person:Person): Observable<Object>{
    return this.httpClient.post(`${this.createURL}`,person);
  }
  getPersonById(id:number):Observable<Person>{
    return this.httpClient.get<Person>(`${this.findPersonById}/${id}`)
  }
  updatePerson(id: number, person: Person): Observable<Object>{
    return this.httpClient.put(`${this.updatePersonById}/${id}`, person);
  }
  deletePerson(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.deletePersonId}/${id}`);
  }
}
