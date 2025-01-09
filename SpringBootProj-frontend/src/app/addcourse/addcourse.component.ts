import { Component } from '@angular/core';
import { CoursesService } from '../courses.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css']
})
export class AddcourseComponent {

  constructor(private service: CoursesService, private router: Router) { }

  course = {

    cId: 0,
    cName: '',
    cDescription: '',
    cDuration: '',
    startDate: '',
    endDate: ''

  }

  onSubmit() {
    if (window.confirm('Confirm course.')) {

      this.service.addCourse(this.course).subscribe({
        next: (data) => {
          alert(data)
          this.router.navigate(['/dashboard/courses'])
        },
        error: (error) => {
          alert(error.error)
        }
      })

    }
  }

  goto() {
    this.router.navigate(['/dashboard/courses'])
  }

}
