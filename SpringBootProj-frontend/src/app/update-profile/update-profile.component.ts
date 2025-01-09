import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent {

  constructor(private service: FacultyService, private router: Router, private route: ActivatedRoute) { }

  fId: any;

  faculty = {

    fId: 0,
    fName: '',
    fEmail: '',
    fRole: '',
    gender: '',
    mobno: 0,
    fUsername: '',
    fPassword: '',
    status: ''

  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((data) => {
      this.fId = data.get('fId');
      this.loaduser();
    })
  }

  loaduser() {
    this.service.getFacultyById(this.fId).subscribe({
      next: (data) => {
        this.faculty = data
      },
      error: (error) => {
        alert(error.error)
      }
    })
  }

  update() {
    if (window.confirm('Confirm details')) {
      this.service.updateFaculty(this.fId, this.faculty).subscribe({
        next: (data) => {
          sessionStorage.setItem('fName', this.faculty.fName);
          alert(data);
          if (sessionStorage.getItem('fRole') === 'Admin') {
            this.router.navigate(['/profile']);
          }
          else if (sessionStorage.getItem('fRole') === 'Faculty') {
            const fid = sessionStorage.getItem('fId')
            this.router.navigate(['/profile'])
          }
        },
        error: (error) => {
          alert(error.error)
          location.reload();
        }
      })
    }
  }

  goto() {
    this.router.navigate(['/profile']);
  }

}
