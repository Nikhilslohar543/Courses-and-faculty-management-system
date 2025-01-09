package com.springboot.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int fId;

	String fName;
	String fEmail;
	String fRole;
	String gender;
	long mobno;

	@Column(unique = true)
	String fUsername;
	String fPassword;
	String status;

	@OneToMany(mappedBy = "facId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	List<CourseAssignment> courseAssignment;

	@OneToMany(mappedBy = "fId", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<Attendance> attendance;

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faculty(int fId, String fName, String fEmail, String fRole, String gender, long mobno, String fUsername,
			String fPassword, String status, List<CourseAssignment> courseAssignment, List<Attendance> attendance) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.fEmail = fEmail;
		this.fRole = fRole;
		this.gender = gender;
		this.mobno = mobno;
		this.fUsername = fUsername;
		this.fPassword = fPassword;
		this.status = status;
		this.courseAssignment = courseAssignment;
		this.attendance = attendance;
	}

	public Faculty(String fName, String fEmail, String fRole, String gender, long mobno, String fUsername,
			String fPassword, String status, List<CourseAssignment> courseAssignment, List<Attendance> attendance) {
		super();
		this.fName = fName;
		this.fEmail = fEmail;
		this.fRole = fRole;
		this.gender = gender;
		this.mobno = mobno;
		this.fUsername = fUsername;
		this.fPassword = fPassword;
		this.status = status;
		this.courseAssignment = courseAssignment;
		this.attendance = attendance;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfEmail() {
		return fEmail;
	}

	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	public String getfRole() {
		return fRole;
	}

	public void setfRole(String fRole) {
		this.fRole = fRole;
	}

	public String getfUsername() {
		return fUsername;
	}

	public void setfUsername(String fUsername) {
		this.fUsername = fUsername;
	}

	public String getfPassword() {
		return fPassword;
	}

	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	public List<CourseAssignment> getCourseAssignment() {
		return courseAssignment;
	}

	public void setCourseAssignment(List<CourseAssignment> courseAssignment) {
		this.courseAssignment = courseAssignment;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "Faculty [fId=" + fId + ", fName=" + fName + ", fEmail=" + fEmail + ", fRole=" + fRole + ", gender="
				+ gender + ", mobno=" + mobno + ", fUsername=" + fUsername + ", fPassword=" + fPassword + ", status="
				+ status + ", courseAssignment=" + courseAssignment + ", attendance=" + attendance + "]";
	}

}
