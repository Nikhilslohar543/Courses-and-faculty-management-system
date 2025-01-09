import { Component } from '@angular/core';
import { CoursesService } from '../courses.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updatecourse',
  templateUrl: './updatecourse.component.html',
  styleUrls: ['./updatecourse.component.css']
})
export class UpdatecourseComponent {

   constructor(private service: CoursesService, private router: Router, private route : ActivatedRoute) { }
  
    course = {
  
      cId: 0,
      cName: '',
      cDescription: '',
      cDuration: '',
      startDate: '',
      endDate: ''
  
    }

    newid : any;

    ngOnInit(): void {
      console.log('update course component')
      this.route.paramMap.subscribe((param) => {
        this.newid = param.get('cId')
        this.loadcourse();
      })
    }

    loadcourse() {
      this.service.getCourseBycId(this.newid).subscribe({
        next: (data) => {
          this.course = JSON.parse(data)
        },
        error: (error) => {
          alert(error.error)
        }
      })
    }
  
    onSubmit() {
      if (window.confirm('Confirm course.')) {
  
        this.service.updateCourse(this.course).subscribe({
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
      this.router.navigate(['/coursedetails',this.newid])
    }

}
