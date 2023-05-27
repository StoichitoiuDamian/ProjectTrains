import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrainListComponent } from './train-list/train-list.component';
import { CreateTrainComponent } from './create-train/create-train.component';
import { FormsModule } from '@angular/forms'; // Importă FormsModule
import {Observable} from 'rxjs';
import { UpdateTrainComponent } from './update-train/update-train.component';
import { UpdateTourComponent } from './update-tour/update-tour.component';
import { CreateTourComponent } from './create-tour/create-tour.component';
import { TourListComponent } from './tour-list/tour-list.component';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { UpdateTicketComponent } from './update-ticket/update-ticket.component';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';
import { CreatePersonComponent } from './create-person/create-person.component';
import { PersonListComponent } from './person-list/person-list.component';
import { UpdatePersonComponent } from './update-person/update-person.component';
import { LoginComponent } from './login/login.component';
@NgModule({
  declarations: [
    AppComponent,
    TrainListComponent,
    CreateTrainComponent,
    UpdateTrainComponent,
    UpdateTourComponent,
    CreateTourComponent,
    TourListComponent,
    TicketListComponent,
    UpdateTicketComponent,
    CreateTicketComponent,
    CreatePersonComponent,
    PersonListComponent,
    UpdatePersonComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
