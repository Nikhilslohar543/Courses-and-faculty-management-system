import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttendancedetailsComponent } from './attendancedetails.component';

describe('AttendancedetailsComponent', () => {
  let component: AttendancedetailsComponent;
  let fixture: ComponentFixture<AttendancedetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AttendancedetailsComponent]
    });
    fixture = TestBed.createComponent(AttendancedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
