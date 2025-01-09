import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  constructor(private http: HttpClient) { }

  url = "http://localhost:9090/api/course";

  getAllCourses(): Observable<any> {

    return this.http.get(`${this.url}`, { responseType: 'text' })
  }

  getFacultyBycId(cId: any): Observable<any> {

    return this.http.get(`${this.url}/faculty/${cId}`, { responseType: 'text' })
  }

  getCourseByfId(id: any): Observable<any> {

    return this.http.get(`${this.url}/${id}`, { responseType: 'text' })
  }

  getCourseBycId(id: any): Observable<any> {

    return this.http.get(`${this.url}/ById/${id}`, { responseType: 'text' })
  }

  addCourse(course: any): Observable<any> {

    return this.http.post(`${this.url}`, course, { responseType: 'text' })
  }

  updateCourse(course: any): Observable<any> {

    return this.http.put(`${this.url}`, course, { responseType: 'text' })
  }

  deleteCourse(id: any): Observable<any> {

    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' })
  }

}
