import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent {

  constructor(private service: FacultyService, private router: Router, private route: ActivatedRoute) { }

  newid: any;

  faculty = {

    fId: 0,
    fName: '',
    fEmail: '',
    fRole: '',
    gender: '',
    mobno :0,
    fUsername: '',
    fPassword: '',
    status: ''

  }

  ngOnInit(): void {

    this.route.paramMap.subscribe((param) => {
      this.newid = param.get('fId');
      this.loaduser();
    })

  }

  loaduser() {

    this.service.getFacultyById(this.newid).subscribe((data) => {
      this.faculty = data
    })

  }

  onSubmit() {
    this.service.updateFaculty(this.newid, this.faculty).subscribe({
      next: (data) => {
        alert(data);
        this.router.navigate(['/dashboard/userdetails',this.newid])
      },
      error : (error)=>{
        alert(error.error)
      }
    })
  }

  goto() { 
    this.router.navigate(['/dashboard/userdetails',this.newid])
  }

}
