import { Component } from '@angular/core';
import { CoursesService } from '../courses.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-course-details',
  templateUrl: './user-course-details.component.html',
  styleUrls: ['./user-course-details.component.css']
})
export class UserCourseDetailsComponent {

  constructor(private service: CoursesService, private router: Router, private route: ActivatedRoute) { }

  course: any = {};

  cId: any;

  ngOnInit(): void {
    this.route.paramMap.subscribe((data) => {
      this.cId = data.get('cId')
      this.loadcourse();
    })
  }

  loadcourse() {
    this.service.getCourseBycId(this.cId).subscribe({
      next: (data) => {
        this.course = JSON.parse(data);
      },
      error: (error)=>{
        alert(error.error);
      }
    })
  }

  goto() {
    this.router.navigate(['/assignedcourses'])
  }

}
