import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { Router } from '@angular/router';
import { Person } from '../person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit{

  persons : Person[] =[];

  constructor(private personService: PersonService, private router: Router) { }

  ngOnInit(): void {
    this.getPerson();
  }

  private getPerson() {
    this.personService.getPersonsList().subscribe((data: Person[]) => {
      this.persons = data;
    });
  }

  updatePerson(id: number) {
    this.router.navigate(['updatePerson', id]);
  }
  deletePerson(id: number) {
    this.personService.deletePerson(id).subscribe(data=>{
      console.log(data);
      this.getPerson();
    })
  }
}
