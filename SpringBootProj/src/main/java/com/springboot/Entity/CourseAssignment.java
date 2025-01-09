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
	Faculty facId;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "courseId")
	Courses couId;

	
	
	public CourseAssignment(Faculty facId, Courses couId) {
		super();
		this.facId = facId;
		this.couId = couId;
	}

	public CourseAssignment(int id, Faculty facId, Courses couId) {
		super();
		this.id = id;
		this.facId = facId;
		this.couId = couId;
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

	public Faculty getFacId() {
		return facId;
	}

	public void setFacId(Faculty facId) {
		this.facId = facId;
	}

	public Courses getCouId() {
		return couId;
	}

	public void setCouId(Courses couId) {
		this.couId = couId;
	}

	@Override
	public String toString() {
		return "CourseAssignment [id=" + id + ", facId=" + facId + ", couId=" + couId + "]";
	}
	
	
	
}
