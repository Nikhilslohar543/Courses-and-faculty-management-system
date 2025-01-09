import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CoursesService } from '../courses.service';

@Component({
  selector: 'app-courselist',
  templateUrl: './courselist.component.html',
  styleUrls: ['./courselist.component.css']
})
export class CourselistComponent {

  constructor(private service: CoursesService, private router: Router) { }

  tempdata: any[] = [];

  ngOnInit(): void {
    this.service.getAllCourses().subscribe({
      next: (data) => {
        if (typeof data === 'string') {
          try {
            this.tempdata = JSON.parse(data);
          } catch (error) {
            this.tempdata = [];
          }
        } else {
          this.tempdata = data;
        }
      },
      error: (error) => {
        alert(error.error);
      }
    });
  }

  onClick(cId: any) {

    this.router.navigate(['coursedetails', cId])

  }

  add() {
    this.router.navigate(['/dashboard/addcourse'])
  }

  goto() {

    this.router.navigate(['/dashboard/wellcome']);

  }

  
  Search(id: any) {
    const cId = Number(id);
    if (!isNaN(cId)) {
      this.router.navigate(['coursedetails', cId]);
    } else {
      alert('Enter valid course id!');
      location.reload();
    }
  }
  

}
