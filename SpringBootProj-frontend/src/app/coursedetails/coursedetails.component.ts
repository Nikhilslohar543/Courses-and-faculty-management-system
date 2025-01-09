import { Component } from '@angular/core';
import { CoursesService } from '../courses.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FacultyService } from '../faculty.service';

@Component({
  selector: 'app-coursedetails',
  templateUrl: './coursedetails.component.html',
  styleUrls: ['./coursedetails.component.css']
})
export class CoursedetailsComponent {

  constructor(private fservice: FacultyService, private service: CoursesService, private router: Router, private route: ActivatedRoute) { }

  course: any = {};

  faculties: any[] = [];

  cId: any;

  ngOnInit(): void {
    this.route.paramMap.subscribe((param) => {
      this.cId = param.get('cId')
      this.loadcourse();
    })
  }

  loadcourse() {
    this.service.getCourseBycId(this.cId).subscribe({
      next: (data) => {
        this.course = JSON.parse(data)
        this.loadfaculies();
      },
      error: (error) => {
        alert(error.error)
        this.router.navigate(['/dashboard/courses'])
      }
    })
  }

  loadfaculies() {
    this.service.getFacultyBycId(this.cId).subscribe({
      next: (data) => {
        this.faculties = JSON.parse(data)
      },
      error: (error) => {
        alert(error.error)
      }
    })
  }

  Assign() {
    this.router.navigate(['/dashboard/assignfaculty',this.cId]);
  }

  Unassign(fid: any) {
    if (window.confirm('Are you want to unassign faculty from this course?')) {
      this.fservice.unassign(fid, this.cId).subscribe({
        next: (data) => {
          const msg = data.message
          alert(msg)
          location.reload();
        },
        error : (error)=>{
          alert(error.error)
        }
      })
    }
  }

  Update(id: any) {

    this.router.navigate(['/dashboard/updatecourse', id]);

  }

  Delete(id: any) {

    if (window.confirm('Are you sure?')) {

      this.service.deleteCourse(id).subscribe({
        next: (data) => {
          alert(data)
          this.router.navigate(['/dashboard/courses'])
        },
        error: (error) => {
          const msg = JSON.stringify(error.error)
          alert(msg)
        }
      })

    }

  }

  goto() {
    this.router.navigate(['/dashboard/courses'])
  }

}
