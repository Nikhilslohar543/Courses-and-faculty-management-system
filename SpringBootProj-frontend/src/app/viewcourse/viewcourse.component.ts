import { Component } from '@angular/core';
import { CoursesService } from '../courses.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FacultyService } from '../faculty.service';

@Component({
  selector: 'app-viewcourse',
  templateUrl: './viewcourse.component.html',
  styleUrls: ['./viewcourse.component.css']
})
export class ViewcourseComponent {

  constructor(private fSer: FacultyService, private service: CoursesService, private router: Router, private route: ActivatedRoute) { }

  cId: any;
  fid: any
  course: any = "";

  ngOnInit(): void {

    this.route.paramMap.subscribe((param) => {
      this.fid = param.get("fId")
      this.cId = param.get('cId')
      this.loadCourse();
    })

  }

  loadCourse() {

    this.service.getCourseBycId(this.cId).subscribe({
      next: (data) => {
        this.course = JSON.parse(data);
      },
      error: (error) => {
        alert(error.error)
      }
    })

  }

  unassign(id: any) {

    if (window.confirm('Confirm Course')) {
      this.fSer.unassign(this.fid, this.cId).subscribe({
        next: (data) => {
          this.router.navigate(['/dashboard/userdetails', this.fid])
        },
        error: (error) => {
          console.log(error)
          alert(error.error)
        }
      })
    }

  }


  goto() {
    this.router.navigate(['/dashboard/userdetails', this.fid])
  }

}
