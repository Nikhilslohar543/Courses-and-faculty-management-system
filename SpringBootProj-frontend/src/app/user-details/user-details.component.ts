import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CoursesService } from '../courses.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent {

  constructor(private fservice: FacultyService, private cservice: CoursesService, private router: Router, private route: ActivatedRoute) { }

  faculty: any = {};

  courses: any[] = [];

  newid: any;

  facultyDetailsVisible = false;
  assignedCoursesVisible = false;
  attendanceVisible = false;

  toggleFacultyDetails() {
    this.facultyDetailsVisible = !this.facultyDetailsVisible;
  }

  toggleAssignedCourses() {
    this.assignedCoursesVisible = !this.assignedCoursesVisible;
  }

  toggleAttendance() {
    this.attendanceVisible = !this.attendanceVisible;
  }

  getUserRole(): string | null {
    return this.faculty.fRole;
  }

  ngOnInit(): void {

    this.route.paramMap.subscribe((param) => {

      this.newid = param.get('fId');
      this.loaduserbyfId();
    })

  }

  loaduserbyfId() {

    this.fservice.getFacultyById(this.newid).subscribe({
      next: (data) => {
        this.faculty = data;
        this.loadcourse();
      },
      error: (error) => {
        // alert(error.error);
        alert('Invalid parameters!')
        this.router.navigate(['/dashboard/users'])
      }
    })

  }


  loadcourse() {
    this.cservice.getCourseByfId(this.newid).subscribe({
      next: (data) => {
        this.courses = JSON.parse(data);
      },
      error: (error) => {
        console.error('Error fetching courses:', error);
        alert(error.error);
      }
    });
  }


  update(id: any) {

    this.router.navigate(['/dashboard/updateuser', id])

  }

  delete(id: any) {
    if (window.confirm('Are you sure, want to delete this user?')) {

      this.fservice.deleteFaculty(id).subscribe({
        next: (data) => {
          // alert(data)
          this.router.navigate(['/dashboard/users'])
        },
        error: (error) => {
          alert(error.error)
        }
      })
    }
  }

  viewCourse(fId: any, cId: any) {

    this.router.navigate(['/dashboard/viewcourse', fId, cId])

  }

  details(aId: any) {
    this.router.navigate(['/attendancedetails', this.newid, aId]);
  }

  addAttendance() {
    this.router.navigate(['/addattendance', this.newid])
  }

  goto() {
    this.router.navigate(['/dashboard/users'])
  }

}
