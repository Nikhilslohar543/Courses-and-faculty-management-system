package com.springboot.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cId;

	String cName;
	String cDescription;
	String cDuration;
	LocalDate startDate;
	LocalDate endDate;

	@OneToMany(mappedBy = "couId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	List<CourseAssignment> courseAssignment;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(String cName, String cDescription, String cDuration, LocalDate startDate, LocalDate endDate,
			List<CourseAssignment> courseAssignment) {
		super();
		this.cName = cName;
		this.cDescription = cDescription;
		this.cDuration = cDuration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseAssignment = courseAssignment;
	}

	public Courses(int cId, String cName, String cDescription, String cDuration, LocalDate startDate, LocalDate endDate,
			List<CourseAssignment> courseAssignment) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cDescription = cDescription;
		this.cDuration = cDuration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseAssignment = courseAssignment;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public String getcDuration() {
		return cDuration;
	}

	public void setcDuration(String cDuration) {
		this.cDuration = cDuration;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<CourseAssignment> getCourseAssignment() {
		return courseAssignment;
	}

	public void setCourseAssignment(List<CourseAssignment> courseAssignment) {
		this.courseAssignment = courseAssignment;
	}

	@Override
	public String toString() {
		return "Courses [cId=" + cId + ", cName=" + cName + ", cDescription=" + cDescription + ", cDuration="
				+ cDuration + ", startDate=" + startDate + ", endDate=" + endDate + ", courseAssignment="
				+ courseAssignment + "]";
	}

}
