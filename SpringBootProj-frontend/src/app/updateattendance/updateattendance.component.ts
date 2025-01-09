import { Component } from '@angular/core';
import { AttendanceService } from '../attendance.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updateattendance',
  templateUrl: './updateattendance.component.html',
  styleUrls: ['./updateattendance.component.css']
})
export class UpdateattendanceComponent {

  constructor(private service: AttendanceService, private router: Router, private route: ActivatedRoute) { }

  attendance = {
    aId: 0,
    aStatus: '',
    aDescription: '',
    aDate: ''
  }

  aId: any;
  fId: any;

  ngOnInit(): void {
    this.route.paramMap.subscribe((param) => {
      this.fId = param.get('fId');
      this.aId = param.get('aId')
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

  onSubmit() {

    if (window.confirm('Confirm details')) {
      this.service.updateAttendance(this.fId, this.attendance).subscribe({
        next: (data) => {
          console.log(data)
          this.router.navigate(['/attendancedetails',this.fId,this.aId])
        },
        error : (error)=>{
          alert(error.error)
        }
      })
    }

  }

  goto() {
    this.router.navigate(['/attendancedetails',this.fId,this.aId])
  }

}
