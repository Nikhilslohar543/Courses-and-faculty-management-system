import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {

  constructor(private http: HttpClient) { }

  url = "http://localhost:9090/api/attendance";

  getAttendance(fId: any): Observable<any> {

    return this.http.get(`${this.url}/${fId}`, { responseType: 'text' })
  }

  getAttendanceById(fId: any, aId: any): Observable<any> {

    return this.http.get(`${this.url}/${fId}/${aId}`, { responseType: 'text' })
  }

  addAttendance(fId: any, attendance: any): Observable<any> {

    return this.http.post(`${this.url}/${fId}`, attendance, { responseType: 'text' })
  }

  updateAttendance(fId: any, attendance: any): Observable<any> {

    return this.http.put(`${this.url}/${fId}`, attendance, { responseType: 'text' })
  }

  deleteAttendance(fId: any, aId: any): Observable<any> {

    return this.http.delete(`${this.url}/${fId}/${aId}`, { responseType: 'text' })
  }


}
