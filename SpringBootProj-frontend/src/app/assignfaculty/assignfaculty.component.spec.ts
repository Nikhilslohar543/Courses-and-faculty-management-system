import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignfacultyComponent } from './assignfaculty.component';

describe('AssignfacultyComponent', () => {
  let component: AssignfacultyComponent;
  let fixture: ComponentFixture<AssignfacultyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssignfacultyComponent]
    });
    fixture = TestBed.createComponent(AssignfacultyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
