import { Component } from '@angular/core';
import { AttendanceService } from '../attendance.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-attendancedetails',
  templateUrl: './attendancedetails.component.html',
  styleUrls: ['./attendancedetails.component.css']
})
export class AttendancedetailsComponent {

  constructor(private service: AttendanceService, private router: Router, private route: ActivatedRoute) { }

  attendance: any = {};

  aId: any;
  fId: any;

  ngOnInit(): void {
    this.route.paramMap.subscribe((param) => {
      this.aId = param.get('aId');
      this.fId = param.get('fId');
      this.loadAttendance();
    })
  }

  loadAttendance() {
    this.service.getAttendanceById(this.fId, this.aId).subscribe({
      next: (data) => {
        this.attendance = JSON.parse(data);
      },
      error: (error) => {
        alert(error.error)
      }
    })
  }

  Update() {
    this.router.navigate(['/updateattendance', this.fId, this.aId])
  }

  Delete(id: any) {
    if (window.confirm('Are you sure?')) {
      this.service.deleteAttendance(this.fId, this.aId).subscribe({
        next: (data) => {
          if (sessionStorage.getItem('fRole') === 'Admin') {
            this.router.navigate(['/dashboard/userdetails', this.fId])
          }
          else if (sessionStorage.getItem('fRole') === 'Faculty') {
            this.router.navigate(['/attendancelist'])
          }        },
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
    else if (sessionStorage.getItem('fRole') === 'Faculty') {
      this.router.navigate(['/attendancelist'])
    }
  }

}
