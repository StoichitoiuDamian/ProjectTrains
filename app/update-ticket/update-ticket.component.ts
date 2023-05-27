import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { ActivatedRoute, Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrls: ['./update-ticket.component.css']
})
export class UpdateTicketComponent implements OnInit{
  id: number = 0;
  ticket: Ticket = new Ticket();

  constructor(
    private ticketService: TicketService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.ticketService.getTicketById(this.id).subscribe(data => {
      this.ticket = data;
    }, error => console.log(error));
  }

  updateTicket() {
    this.ticketService.updateTicket(this.id, this.ticket).subscribe(data => {
      console.log(data);
      this.ticket = new Ticket();
      this.gotoList();
    }, error => console.log(error));
  }

  onSubmit() {
    this.updateTicket();
  }

  gotoList() {
    this.router.navigate(['/getTicket']);
  }

}
