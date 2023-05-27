import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import { Tour } from '../tour';
import { TourService } from '../tour.service';

@Component({
  selector: 'app-create-tour',
  templateUrl: './create-tour.component.html',
  styleUrls: ['./create-tour.component.css']
})
export class CreateTourComponent implements OnInit{
 
 tour : Tour = new Tour();

 constructor(private tourService : TourService, private router:Router){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  async saveTour() {
    try {
      const data = await firstValueFrom(this.tourService.createTour(this.tour));
  
      console.log(data);
      this.goToTourList();
    } catch (error) {
      console.log(error);
    }
  }

  goToTourList(){
    this.router.navigate(['/showTour']);
  }

  onSubmit(){
    console.log(this.tour);
    this.saveTour();
  }
}
