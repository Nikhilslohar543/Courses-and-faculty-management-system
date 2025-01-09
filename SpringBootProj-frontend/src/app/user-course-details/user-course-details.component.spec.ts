import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCourseDetailsComponent } from './user-course-details.component';

describe('UserCourseDetailsComponent', () => {
  let component: UserCourseDetailsComponent;
  let fixture: ComponentFixture<UserCourseDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserCourseDetailsComponent]
    });
    fixture = TestBed.createComponent(UserCourseDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
