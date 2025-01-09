package com.springboot.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int aId;

	String aStatus;
	LocalDate aDate;
	String aDescription;

	@ManyToOne
	@JoinColumn(name = "facultyId")
	@JsonBackReference
	Faculty fId;

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance(int aId, String aStatus, LocalDate aDate, String aDescription, Faculty fId) {
		super();
		this.aId = aId;
		this.aStatus = aStatus;
		this.aDate = aDate;
		this.aDescription = aDescription;
		this.fId = fId;
	}

	public Attendance(String aStatus, LocalDate aDate, String aDescription, Faculty fId) {
		super();
		this.aStatus = aStatus;
		this.aDate = aDate;
		this.aDescription = aDescription;
		this.fId = fId;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaStatus() {
		return aStatus;
	}

	public void setaStatus(String aStatus) {
		this.aStatus = aStatus;
	}

	public LocalDate getaDate() {
		return aDate;
	}

	public void setaDate(LocalDate aDate) {
		this.aDate = aDate;
	}

	public String getaDescription() {
		return aDescription;
	}

	public void setaDescription(String aDescription) {
		this.aDescription = aDescription;
	}

	public Faculty getfId() {
		return fId;
	}

	public void setfId(Faculty fId) {
		this.fId = fId;
	}

	@Override
	public String toString() {
		return "Attendance [aId=" + aId + ", aStatus=" + aStatus + ", aDate=" + aDate + ", aDescription=" + aDescription
				+ ", fId=" + fId + "]";
	}

}
