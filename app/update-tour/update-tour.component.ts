import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tour } from '../tour';
import { TourService } from '../tour.service';

@Component({
  selector: 'app-update-tour',
  templateUrl: './update-tour.component.html',
  styleUrls: ['./update-tour.component.css']
})
export class UpdateTourComponent implements OnInit{
  id: number = 0;
  tour : Tour = new Tour();

  constructor(
    private tourService: TourService,
    private router: Router,
    private route: ActivatedRoute
  ) { }


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.tourService.getTourById(this.id).subscribe(data => {
      this.tour = data;
    }, error => console.log(error));
  }

  updateTour() {
    this.tourService.updateTour(this.id, this.tour).subscribe((data: any) => {
      console.log(data);
      this.tour = new Tour();
      this.gotoList();
    }, error => console.log(error));
  }

  onSubmit() {
    this.updateTour();
  }

  gotoList() {
    this.router.navigate(['/showTour']);
  }
  

}
