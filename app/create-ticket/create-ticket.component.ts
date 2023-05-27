import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})
export class CreateTicketComponent implements OnInit{
 ticket : Ticket = new Ticket ();

 constructor(private ticketService : TicketService, private router:Router){}

 ngOnInit(): void {
   throw new Error('Method not implemented.');
 }

 async saveTicket() {
   try {
     const data = await firstValueFrom(this.ticketService.createTicket(this.ticket));
 
     console.log(data);
     this.goToTicketList();
   } catch (error) {
     console.log(error);
   }
 }

 goToTicketList(){
   this.router.navigate(['/getTicket']);
 }

 onSubmit(){
   console.log(this.ticket);
   this.saveTicket();
 }
 

}
