import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CoursesService } from '../courses.service';

@Component({
  selector: 'app-assignfaculty',
  templateUrl: './assignfaculty.component.html',
  styleUrls: ['./assignfaculty.component.css']
})
export class AssignfacultyComponent {

  constructor(private cSer: CoursesService, private service: FacultyService, private router: Router, private route: ActivatedRoute) { }

  tempdata: any[] = [];

  faculties: any[] = [];

  course: any = {};

  cId: any

  fId: any

  fIds: any[] = [];

  ngOnInit(): void {
    this.route.paramMap.subscribe((data) => {
      this.cId = data.get('cId')

      this.loadfaculties();
      this.loadcourse();
    })
  }

  loadfaculties() {
    this.service.getAllFaculty().subscribe({
      next: (data) => {
        let faculty = JSON.parse(data);
        this.tempdata = faculty

        this.faculties = this.tempdata.filter(faculty => faculty.fRole.toLowerCase() !== 'admin');
      },
      error: (error) => {
        alert(error.error)
      }
    })
  }

  loadcourse() {
    this.cSer.getCourseBycId(this.cId).subscribe({
      next: (data) => {
        this.course = JSON.parse(data)
      },
      error: (error) => {
        alert(error.error)
      }
    })
  }

  onCheckboxChange(event: any) {
    const facultyId = event.target.value;
    if (event.target.checked) {
      this.fIds.push(facultyId);
    } else {
      this.fIds = this.fIds.filter(id => id !== facultyId);
    }
  }


  Assign() {
    if (window.confirm('Confirm Assignments')) {
      this.service.assign(this.fIds, this.cId).subscribe({
        next: (data) => {
          alert(data);
          this.router.navigate(['/coursedetails', this.cId]);
        },
        error: (error) => {
          if (error.status === 409) {
            alert(error.error || 'Conflict: Some faculties are already assigned to this course.');
          } else {
            console.error('Error:', error);
            alert('An unexpected error occurred.');
          }
        },
      });
    }
  }
 
  Search(fId: any){
    
  }

  goto() {
    this.router.navigate(['/coursedetails', this.cId])
  }

}
