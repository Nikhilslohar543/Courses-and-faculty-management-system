import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FacultyService } from '../faculty.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(private service: FacultyService, private router: Router) { }

  faculty = {

    fId: 0,
    fName: '',
    fEmail: '',
    fRole: 'Faculty',
    gender: '',
    mobno : '',
    fUsername: '',
    fPassword: '',
    status: ''

  }

  onSignup() {

    this.service.signup(this.faculty).subscribe({
      next: (data) => {

        console.log(this.faculty);
        alert(data);
        this.router.navigate(['/home/signin'])

      },
      error: (error) => {
        alert(error.error);
        location.reload();
      }
    })

  }

}
