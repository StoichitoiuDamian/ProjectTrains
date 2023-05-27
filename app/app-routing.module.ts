import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TrainListComponent } from './train-list/train-list.component';
import { CreateTrainComponent } from './create-train/create-train.component';
import { UpdateTrainComponent } from './update-train/update-train.component';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';
import { PersonListComponent } from './person-list/person-list.component';
import { CreatePersonComponent } from './create-person/create-person.component';
import { CreateTourComponent } from './create-tour/create-tour.component';
import { TourListComponent } from './tour-list/tour-list.component';
import { UpdateTicketComponent } from './update-ticket/update-ticket.component';
import { UpdateTourComponent } from './update-tour/update-tour.component';
import { UpdatePersonComponent } from './update-person/update-person.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: 'getTrain', component: TrainListComponent},
  {path: 'createTrain',component: CreateTrainComponent},
  {path: 'updateTrain/:id', component: UpdateTrainComponent},
  {path: 'updateTicket/:id', component: UpdateTicketComponent},
  {path: 'updateTour/:id', component: UpdateTourComponent},
  {path: 'updatePerson/:id', component: UpdatePersonComponent},
  {path: 'Login',component: LoginComponent},
  {path: 'getTicket',component :TicketListComponent},
  {path: 'addTicket',component :CreateTicketComponent},
  {path: 'showPerson',component :PersonListComponent},
  {path: 'addPerson',component :CreatePersonComponent},
  {path: 'showTour',component :TourListComponent},
  {path: 'addTour',component :CreateTourComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
