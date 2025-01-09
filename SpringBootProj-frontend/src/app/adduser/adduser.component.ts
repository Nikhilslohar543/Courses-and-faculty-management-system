import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent {

  constructor(private service: FacultyService, private router: Router) { }

  faculty: any = {};

  onSubmit() {
    if (window.confirm('Confirm details')) {
      this.service.addFaculty(this.faculty).subscribe({
        next: (data) => {
          alert(data)
          this.router.navigate(['/dashboard/users'])
        },
        error : (error)=>{
          alert(error.error)
        }
      })
    }
  }

  goto() {
    this.router.navigate(['/dashboard/users'])
  }

}
