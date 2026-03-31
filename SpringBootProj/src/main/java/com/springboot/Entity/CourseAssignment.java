package com.springboot.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CourseAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "facultyId")
    Faculty facultyId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "courseId")
    Courses coursesId;


    public CourseAssignment(Faculty facultyId, Courses coursesId) {
        super();
        this.facultyId = facultyId;
        this.coursesId = coursesId;
    }

    public CourseAssignment(int id, Faculty facultyId, Courses coursesId) {
        super();
        this.id = id;
        this.facultyId = facultyId;
        this.coursesId = coursesId;
    }

    public CourseAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faculty getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Faculty facultyId) {
        this.facultyId = facultyId;
    }

    public Courses getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(Courses coursesId) {
        this.coursesId = coursesId;
    }

    @Override
    public String toString() {
        return "CourseAssignment [id=" + id + ", facId=" + facultyId + ", couId=" + coursesId + "]";
    }


}
