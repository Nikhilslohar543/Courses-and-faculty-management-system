import { Component } from '@angular/core';
import { CoursesService } from '../courses.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-assigned-courses',
  templateUrl: './assigned-courses.component.html',
  styleUrls: ['./assigned-courses.component.css']
})
export class AssignedCoursesComponent {

  constructor(private service : CoursesService, private router : Router){}

  courses: any[] = [];

  fId : any;

  ngOnInit():void{

    this.fId = sessionStorage.getItem('fId')

    this.service.getCourseByfId(this.fId).subscribe({
      next: (data) => {
          this.courses = JSON.parse(data);
      },
      error: (error) => {
        console.error('Error fetching courses:', error);
        alert(error.error);
      }
    });
  }

  onClick(cId : any){
    this.router.navigate(['/user-course-details',cId])
  }

  goto(){
    this.router.navigate(['/dashboard/wellcome']);
  }

}
