import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Person } from '../person';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = "";
  password: string = "";
  isLoggedIn: boolean = false;
  person:Person=new Person();

  constructor(private router: Router) {}

  login() {

    if (this.person.username == "admin" && this.person.password == "994") {
      this.isLoggedIn = false; 
      console.log("Autentificare esuata!");
    } else {
      this.isLoggedIn = true;
      console.log("Autentificare reusita!");
      this.gotoList();
    }
  }

  gotoList() {
    this.router.navigate(['/getTrain']);
  }
}