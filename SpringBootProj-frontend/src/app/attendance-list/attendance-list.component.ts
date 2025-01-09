import { Component } from '@angular/core';
import { AttendanceService } from '../attendance.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-attendance-list',
  templateUrl: './attendance-list.component.html',
  styleUrls: ['./attendance-list.component.css']
})
export class AttendanceListComponent {

  constructor(private service: AttendanceService, private router: Router) { }

  attendance: any[] = [];

  ngOnInit(): void {
    const fId = sessionStorage.getItem('fId');
    this.service.getAttendance(fId).subscribe({
      next: (data) => {
        this.attendance = JSON.parse(data)
      }
    })
  }

  onClick(id: any) {
    const fId = sessionStorage.getItem('fId')
    this.router.navigate(['/attendancedetails',fId,id])

  }

  add() {
    const fId = sessionStorage.getItem('fId')
    this.router.navigate(['/addattendance', fId])
  }

  goto() {
    this.router.navigate(['/dashboard/wellcome'])

  }

}
