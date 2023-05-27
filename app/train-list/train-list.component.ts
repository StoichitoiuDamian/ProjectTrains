import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-train-list',
  templateUrl: './train-list.component.html',
  styleUrls: ['./train-list.component.css']
})
export class TrainListComponent implements OnInit {
  trains: Train[] = [];

  constructor(private trainService: TrainService, private router: Router) { }

  ngOnInit(): void {
    this.getTrainList();
  }

  private getTrainList() {
    this.trainService.getTrainsList().subscribe((data: Train[]) => {
      this.trains = data;
    });
  }

  updateTrain(id: number) {
    this.router.navigate(['updateTrain', id]);
  }
  deleteTrain(id: number) {
    this.trainService.deleteTrain(id).subscribe(data=>{
      console.log(data);
      this.getTrainList();
    })
  }
}