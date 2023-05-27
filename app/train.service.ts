import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Train } from './train';

@Injectable({
  providedIn: 'root'
})
export class TrainService {
 

  private baseURL = "http://localhost:8080/train";
  private createURL = "http://localhost:8080/createTrain";
  private findTrainById = "http://localhost:8080/findTrain";
  private updateTrainById = "http://localhost:8080/putTrain";
  private deleteTrainId = "http://localhost:8080/deleteTrain";
  constructor(private httpClient: HttpClient) { }

  getTrainsList(): Observable<Train[]> {
    return this.httpClient.get<Train[]>(this.baseURL);
  }

  createTrain(train:Train): Observable<Object>{
    return this.httpClient.post(`${this.createURL}`,train);
  }
  getTrainById(id:number):Observable<Train>{
    return this.httpClient.get<Train>(`${this.findTrainById}/${id}`)
  }
  updateTrain(id: number, train: Train): Observable<Object>{
    return this.httpClient.put(`${this.updateTrainById}/${id}`, train);
  }
  deleteTrain(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.deleteTrainId}/${id}`);
  }
}
