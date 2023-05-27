import { Component, OnInit } from '@angular/core';
import { Tour } from '../tour';
import { TourService } from '../tour.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit{
  tours: Tour[] = [];

  constructor(private tourSerive: TourService, private router: Router){}

  ngOnInit(): void {
    this.getTour();
  }

  private getTour() {
    this.tourSerive.getTourList().subscribe((data: Tour[]) => {
      this.tours = data;
    });
  }

  updateTour(id: number) {
    this.router.navigate(['updateTour', id]);
  }
  deleteTour(id: number) {
    this.tourSerive.deleteTour(id).subscribe(data=>{
      console.log(data);
      this.getTour();
    })
  }
}
