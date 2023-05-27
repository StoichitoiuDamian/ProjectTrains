import { Component, OnInit } from '@angular/core';
import { Train } from '../train';
import { TrainService } from '../train.service';
import { ActivatedRoute, Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import { Person } from '../person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-update-person',
  templateUrl: './update-person.component.html',
  styleUrls: ['./update-person.component.css']
})
export class UpdatePersonComponent implements OnInit{
  id: number = 0;
  person: Person = new Person();
  constructor(
    private personService: PersonService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.personService.getPersonById(this.id).subscribe(data => {
      this.person = data;
    }, error => console.log(error));
  }

  updatePerson() {
    this.personService.updatePerson(this.id, this.person).subscribe(data => {
      console.log(data);
      this.person = new Person();
      this.gotoList();
    }, error => console.log(error));
  }

  onSubmit() {
    this.updatePerson();
  }

  gotoList() {
    this.router.navigate(['/showPerson']);
  }
}
