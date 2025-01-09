import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewcourseComponent } from './viewcourse.component';

describe('ViewcourseComponent', () => {
  let component: ViewcourseComponent;
  let fixture: ComponentFixture<ViewcourseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewcourseComponent]
    });
    fixture = TestBed.createComponent(ViewcourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
