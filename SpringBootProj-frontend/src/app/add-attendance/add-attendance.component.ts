import { Component } from '@angular/core';
import { AttendanceService } from '../attendance.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-attendance',
  templateUrl: './add-attendance.component.html',
  styleUrls: ['./add-attendance.component.css']
})
export class AddAttendanceComponent {

  constructor(private service: AttendanceService, private router: Router, private route: ActivatedRoute) { }

  attendance: any = {};

  fId: any;

  ngOnInit(): void {
    this.route.paramMap.subscribe((param) => {
      this.fId = param.get('fId')
    })
  }

  onSubmit() {
    if (window.confirm('Confirm details')) {
      this.service.addAttendance(this.fId, this.attendance).subscribe({
        next: (data) => {
          console.log(data)
          if (sessionStorage.getItem('fRole') === 'Admin') {
            this.router.navigate(['/dashboard/userdetails', this.fId])
          }
          else if(sessionStorage.getItem('fRole')==='Faculty'){
            this.router.navigate(['/attendancelist'])
          }
        },
        error: (error) => {
          alert(error.error)
        }
      })
    }
  }

  goto() {
    if (sessionStorage.getItem('fRole') === 'Admin') {
      this.router.navigate(['/dashboard/userdetails', this.fId])
    }
    else if(sessionStorage.getItem('fRole')==='Faculty'){
      this.router.navigate(['/attendancelist'])
    }
  }

}
