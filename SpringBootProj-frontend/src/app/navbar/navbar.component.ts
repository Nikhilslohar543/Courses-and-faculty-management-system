import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private router: Router){}

  newid : any;

  isAdmin(): boolean {

    return sessionStorage.getItem('fRole') === 'Admin';

  }

  isFaculty(): boolean {

    return sessionStorage.getItem('fRole') === 'Faculty';

  }

  onClick(){

    this.newid = sessionStorage.getItem('fId');
    this.router.navigate(['/profile',this.newid])

  }

  logout(): void {
    if (window.confirm('Do you want to logout?')) {
      sessionStorage.clear();
      this.router.navigate(['/home/signin']);
    }
  }

}
