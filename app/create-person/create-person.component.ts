import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import { Person } from '../person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-create-person',
  templateUrl: './create-person.component.html',
  styleUrls: ['./create-person.component.css']
})
export class CreatePersonComponent implements OnInit{

  person : Person = new Person();

  constructor(private personService : PersonService, private router:Router){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  async savePerson() {
    try {
      const data = await firstValueFrom(this.personService.createPerson(this.person));
  
      console.log(data);
      this.goToPersonList();
    } catch (error) {
      console.log(error);
    }
  }

  goToPersonList(){
    this.router.navigate(['/showPerson']);
  }

  onSubmit(){
    console.log(this.person);
    this.savePerson();
  }
}
