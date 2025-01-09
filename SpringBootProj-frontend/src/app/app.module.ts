import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserlistComponent } from './userlist/userlist.component';
import { CourselistComponent } from './courselist/courselist.component';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ViewcourseComponent } from './viewcourse/viewcourse.component';
import { CoursedetailsComponent } from './coursedetails/coursedetails.component';
import { UpdatecourseComponent } from './updatecourse/updatecourse.component';
import { AddcourseComponent } from './addcourse/addcourse.component';
import { AdduserComponent } from './adduser/adduser.component';
import { AttendancedetailsComponent } from './attendancedetails/attendancedetails.component';
import { UpdateattendanceComponent } from './updateattendance/updateattendance.component';
import { AddAttendanceComponent } from './add-attendance/add-attendance.component';
import { AssignfacultyComponent } from './assignfaculty/assignfaculty.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AssignedCoursesComponent } from './assigned-courses/assigned-courses.component';
import { AttendanceListComponent } from './attendance-list/attendance-list.component';
import { UserCourseDetailsComponent } from './user-course-details/user-course-details.component';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignupComponent,
    SigninComponent,
    DashboardComponent,
    UserlistComponent,
    CourselistComponent,
    ProfileComponent,
    UpdateProfileComponent,
    UserDetailsComponent,
    UpdateUserComponent,
    ViewcourseComponent,
    CoursedetailsComponent,
    UpdatecourseComponent,
    AddcourseComponent,
    AdduserComponent,
    AttendancedetailsComponent,
    UpdateattendanceComponent,
    AddAttendanceComponent,
    AssignfacultyComponent,
    NavbarComponent,
    AssignedCoursesComponent,
    AttendanceListComponent,
    UserCourseDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
