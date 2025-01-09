import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  constructor(private http: HttpClient) { }

  url = "http://localhost:9090/api/faculty";

  signin(fUsername: any, fPassword: any): Observable<any> {
    return this.http.post(`${this.url}/signin`, { fUsername, fPassword }, { responseType: 'text' });
  }

  signup(Faculty: any): Observable<any> {
    return this.http.post(`${this.url}/signup`, Faculty, { responseType: 'text' });
  }

  assign(fIds: any[], cId: any): Observable<any> {
    const params = fIds.map(id => `fIds=${id}`).join('&');
    return this.http.put(`${this.url}/assign/${cId}?${params}`, null, { responseType: 'text' });
  }  

  unassign(fId: any, cId: any): Observable<any> {
    return this.http.put(`${this.url}/unassign/${fId}/${cId}`, { responseType: 'text' });
  }

  getAllFaculty(): Observable<any> {
    return this.http.get(`${this.url}`, { responseType: 'text' });
  }

  getFacultyById(fId: any): Observable<any> {
    return this.http.get(`${this.url}/${fId}`);
  }

  getFacultyByUserename(fUsername: any):Observable<any>{
    return this.http.get(`${this.url}/ByUsername/${fUsername}`)
  }

  addFaculty(Faculty: any): Observable<any> {
    return this.http.post(`${this.url}`, Faculty, { responseType: 'text' })
  }

  updateFaculty(fId: any, Faculty: any): Observable<any> {
    return this.http.put(`${this.url}/${fId}`, Faculty, { responseType: 'text' });
  }

  deleteFaculty(fId: any): Observable<any> {
    return this.http.delete(`${this.url}/${fId}`, { responseType: 'text' });
  }

}
