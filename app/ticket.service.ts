import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from './ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private baseURL = "http://localhost:8080/ticket";
  private createURL = "http://localhost:8080/postTicket";
  private findTicketById = "http://localhost:8080/findTicket";
  private updateTicketById = "http://localhost:8080/putTicket";
  private deleteTicketId = "http://localhost:8080/deleteTicket";
  constructor(private httpClient: HttpClient) { }

  getTicketList(): Observable<Ticket[]> {
    return this.httpClient.get<Ticket[]>(this.baseURL);
  }

  createTicket(ticket:Ticket): Observable<Object>{
    return this.httpClient.post(`${this.createURL}`,ticket);
  }
  getTicketById(id:number):Observable<Ticket>{
    return this.httpClient.get<Ticket>(`${this.findTicketById}/${id}`)
  }
  updateTicket(id: number, ticket: Ticket): Observable<Object>{
    return this.httpClient.put(`${this.updateTicketById}/${id}`, ticket);
  }
  deleteTicket(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.deleteTicketId}/${id}`);
  }
}
