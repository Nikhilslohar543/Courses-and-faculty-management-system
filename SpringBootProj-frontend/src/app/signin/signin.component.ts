import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {

  constructor(private service: FacultyService, private router: Router) { }

  fUsername = '';
  fPassword = '';

  ngOnInit(): void {

    sessionStorage.clear();

  }

  onSignin() {

    this.service.signin(this.fUsername, this.fPassword).subscribe({
      next: (data) => {

        let faculty = JSON.parse(data)
        const name = faculty.fName;
        const id = faculty.fId;
        const role = faculty.fRole;
        sessionStorage.setItem('fName', name);
        sessionStorage.setItem('fId', id);
        sessionStorage.setItem('fRole', role);
        alert("Logged in successfully");

        this.router.navigate(['/dashboard/wellcome'])
        console.log("hello ",name)

      },
      error: (error) => {
        alert(error.error)
        location.reload();
      }
    })

  }

}
