import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CourselistComponent } from './courselist/courselist.component';
import { UserlistComponent } from './userlist/userlist.component';
import { RoleGuard } from './role.guard';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ViewcourseComponent } from './viewcourse/viewcourse.component';
import { CoursedetailsComponent } from './coursedetails/coursedetails.component';
import { UpdatecourseComponent } from './updatecourse/updatecourse.component';
import { AddcourseComponent } from './addcourse/addcourse.component';
import { AttendancedetailsComponent } from './attendancedetails/attendancedetails.component';
import { UpdateattendanceComponent } from './updateattendance/updateattendance.component';
import { AddAttendanceComponent } from './add-attendance/add-attendance.component';
import { AdduserComponent } from './adduser/adduser.component';
import { AssignfacultyComponent } from './assignfaculty/assignfaculty.component';
import { AssignedCoursesComponent } from './assigned-courses/assigned-courses.component';
import { AttendanceListComponent } from './attendance-list/attendance-list.component';
import { UserCourseDetailsComponent } from './user-course-details/user-course-details.component';

const routes: Routes = [

  {
    path: '', redirectTo: 'home', pathMatch: 'full'
  },
  {
    path: 'home', children: [

      {
        path: '', component: HomeComponent
      },
      {
        path: 'signup', component: SignupComponent
      },
      {
        path: 'signin', component: SigninComponent
      }

    ]
  },

  {
    path: 'dashboard', children: [

      {
        path: 'wellcome', component: DashboardComponent
      },
      {
        path: 'courses', component: CourselistComponent, canActivate: [RoleGuard], data: { role: 'Admin' }
      },
      {
        path: 'users', component: UserlistComponent, canActivate: [RoleGuard], data: { role: 'Admin' }
      },
      {
        path: 'userdetails/:fId', component: UserDetailsComponent, canActivate: [RoleGuard], data: {role: 'Admin'}
      },
      {
        path: 'adduser', component: AdduserComponent, canActivate: [RoleGuard], data: {role : 'Admin'}
      },
      {
        path: 'updateuser/:fId', component: UpdateUserComponent, canActivate: [RoleGuard], data: {role: 'Admin'}
      },
      {
        path: 'viewcourse/:fId/:cId', component: ViewcourseComponent, canActivate: [RoleGuard], data: {role: 'Admin'}
      },
      {
        path: 'updatecourse/:cId', component: UpdatecourseComponent, canActivate: [RoleGuard], data: {role : 'Admin'} 
      },
      {
        path: 'addcourse', component: AddcourseComponent, canActivate: [RoleGuard], data: {role : 'Admin'}
      },
      {
        path: 'assignfaculty/:cId', component: AssignfacultyComponent, canActivate: [RoleGuard], data: {role : 'Admin'}
      }
    ]
  },
  {
    path: 'attendancelist', component: AttendanceListComponent, canActivate: [RoleGuard], data: {role : 'Faculty'}
  },
  {
    path: 'assignedcourses', component: AssignedCoursesComponent, canActivate: [RoleGuard], data: {role : 'Faculty'}
  },
  {
    path: 'user-course-details/:cId', component: UserCourseDetailsComponent, canActivate: [RoleGuard], data: {role : 'Faculty'}
  },
  {
    path: 'profile', component: ProfileComponent
  },
  {
    path: 'updateProfiile/:fId', component: UpdateProfileComponent
  },
  {
    path: 'coursedetails/:cId', component: CoursedetailsComponent
  },
  {
    path: 'attendancedetails/:fId/:aId', component: AttendancedetailsComponent
  },
  {
    path: 'updateattendance/:fId/:aId', component: UpdateattendanceComponent
  },
  {
    path: 'addattendance/:fId', component: AddAttendanceComponent
  },
  {
    path: '**', redirectTo: 'home'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
