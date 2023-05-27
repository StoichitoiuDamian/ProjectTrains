import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { Router } from '@angular/router';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit{
  tickets: Ticket[] = [];

  constructor(private ticketService: TicketService, private router: Router) { }
  
  ngOnInit(): void {
    this.getTicket();
  }

  private getTicket() {
    this.ticketService.getTicketList().subscribe((data: Ticket[]) => {
      this.tickets = data;
    });
  }

  updateTicket(id: number) {
    this.router.navigate(['updateTicket', id]);
  }
  deleteTicket(id: number) {
    this.ticketService.deleteTicket(id).subscribe(data=>{
      console.log(data);
      this.getTicket();
    })
  }
}
