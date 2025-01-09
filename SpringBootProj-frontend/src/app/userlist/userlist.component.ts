import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent {

  constructor(private service: FacultyService, private router: Router, private route: ActivatedRoute) { }

  tempdata: any[] = [];

  filteredData: any[] = [];

  ngOnInit() {

    this.service.getAllFaculty().subscribe({
      next: (data) => {
        let faculty = JSON.parse(data);
        this.tempdata = faculty
        this.filterFaculties();
      },
      error: (error) => {
        alert(error.error)
      }
    })

  }
  filterFaculties() {
    const id = Number(sessionStorage.getItem('fId'))
    if (id === 1) {
      this.filteredData = this.tempdata.filter(faculty => faculty.fId !== 1);
    }
    else if (id !== 1) {
      this.filteredData = this.tempdata.filter(faculty => faculty.fRole !== 'Admin');
    }
  }

  goto() {

    this.router.navigate(['/dashboard/wellcome']);

  }

  add() {
    this.router.navigate(['/dashboard/adduser'])
  }

  onClick(id: any) {

    this.router.navigate(['/dashboard/userdetails', id])

  }

  Search(fId: any) {
    if (!isNaN(Number(fId))) {
      if(Number(fId) === 1){
        alert('User not found!')
        location.reload();
      }else{
        this.router.navigate(['/dashboard/userdetails', fId]);
      }
    } else {
      alert('Enter valid parameters!')
      location.reload();
    }
  }



}
