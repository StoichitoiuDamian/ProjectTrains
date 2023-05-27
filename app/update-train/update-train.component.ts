import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { ActivatedRoute, Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-update-train',
  templateUrl: './update-train.component.html',
  styleUrls: ['./update-train.component.css']
})
export class UpdateTrainComponent implements OnInit {
  id: number = 0;
  train: Train = new Train();

  constructor(
    private trainService: TrainService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.trainService.getTrainById(this.id).subscribe(data => {
      this.train = data;
    }, error => console.log(error));
  }

  updateTrain() {
    this.trainService.updateTrain(this.id, this.train).subscribe(data => {
      console.log(data);
      this.train = new Train();
      this.gotoList();
    }, error => console.log(error));
  }

  onSubmit() {
    this.updateTrain();
  }

  gotoList() {
    this.router.navigate(['/getTrain']);
  }
}