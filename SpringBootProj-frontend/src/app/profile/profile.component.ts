import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  constructor(private service: FacultyService, private router: Router, private route: ActivatedRoute) { }

  faculty: any = {};

  newid: any

  ngOnInit(): void {

    this.newid = sessionStorage.getItem('fId')

    this.service.getFacultyById(this.newid).subscribe({
      next: (data) => {
        this.faculty = data;
      },
      error: (error) => {
        alert(error.error);
      }
    })
  }


  goto() {

    this.router.navigate(['/dashboard/wellcome']);

  }

  update() {

    const fId = sessionStorage.getItem('fId');
    this.router.navigate(['/updateProfiile', fId]);

  }

  logout(): void {
    if (window.confirm('Do you want to logout?')) {
      sessionStorage.clear();
      this.router.navigate(['/home/signin']);
    }
  }
}
