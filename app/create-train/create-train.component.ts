import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-create-train',
  templateUrl: './create-train.component.html',
  styleUrls: ['./create-train.component.css']
})
export class CreateTrainComponent implements OnInit{
  train : Train = new Train();
  constructor(private trainService : TrainService, private router:Router){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  async saveTrain() {
    try {
      const data = await firstValueFrom(this.trainService.createTrain(this.train));
  
      console.log(data);
      this.goToTrainList();
    } catch (error) {
      console.log(error);
    }
  }

  goToTrainList(){
    this.router.navigate(['/getTrain']);
  }

  onSubmit(){
    console.log(this.train);
    this.saveTrain();
  }
  
}
