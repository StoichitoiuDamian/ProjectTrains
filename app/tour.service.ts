import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tour } from './tour';

@Injectable({
  providedIn: 'root'
})
export class TourService {

  private baseURL = "http://localhost:8080/tour";
  private createURL = "http://localhost:8080/postTour";
  private findTourById = "http://localhost:8080/findTour";
  private updateTourById = "http://localhost:8080/putTour";
  private deleteTourId = "http://localhost:8080/deleteTour";
  constructor(private httpClient: HttpClient) {}

  getTourList(): Observable<Tour[]> {
    return this.httpClient.get<Tour[]>(this.baseURL);
  }

  createTour(tour:Tour): Observable<Object>{
    return this.httpClient.post(`${this.createURL}`,tour);
  }
  getTourById(id:number):Observable<Tour>{
    return this.httpClient.get<Tour>(`${this.findTourById}/${id}`)
  }
  updateTour(id: number, tour: Tour): Observable<Object>{
    return this.httpClient.put(`${this.updateTourById}/${id}`, tour);
  }
  deleteTour(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.deleteTourId}/${id}`);
  }
}
