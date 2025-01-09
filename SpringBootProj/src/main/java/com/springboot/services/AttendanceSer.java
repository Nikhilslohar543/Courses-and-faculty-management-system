package com.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.DAO.AttendanceDao;
import com.springboot.DAO.FacultyDao;
import com.springboot.Entity.Attendance;
import com.springboot.Entity.Faculty;

@Service
public class AttendanceSer {

	@Autowired
	private AttendanceDao aDao;

	@Autowired
	private FacultyDao fDao;

	public List<Attendance> getAttendance(int fId) {

		Optional<Faculty> exist = fDao.findById(fId);

		if (exist.isPresent()) {

			List<Attendance> list = aDao.findAttendanceByFacultyId(fId);
			return list;

		} else {
			return null;
		}
	}

	public ResponseEntity<?> getAttendanceById(int fId, int aId) {

		Optional<Faculty> exist = fDao.findById(fId);

		if (exist.isPresent()) {
			Optional<Attendance> attend = aDao.findById(aId);

			if (attend.isPresent()) {
				Attendance atten = attend.get();

				return ResponseEntity.ok(atten);
			} else {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Attendance not found!");
			}
		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty not found!");
		}
	}

	public ResponseEntity<?> addAttendance(int fId, Attendance attendance) {

		Optional<Faculty> exist = fDao.findById(fId);

		if (exist.isPresent() && attendance != null) {
			Faculty fac = exist.get();

			attendance.setfId(fac);
			aDao.save(attendance);
			return ResponseEntity.ok("Attendance marked.");

		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faculty not found!");
		}
	}

	public ResponseEntity<?> updateAttendance(int fId, Attendance attendance) {

		Optional<Faculty> fexist = fDao.findById(fId);

		if (fexist.isPresent()) {
			Faculty faculty = fexist.get();

			Optional<Attendance> aexist = aDao.findById(attendance.getaId());
			if (aexist.isPresent()) {

				Attendance attend = new Attendance();

				attend.setaId(attendance.getaId());
				attend.setaStatus(attendance.getaStatus());
				attend.setaDate(attendance.getaDate());
				attend.setaDescription(attendance.getaDescription());
				attend.setfId(faculty);

				aDao.save(attend);
				return ResponseEntity.ok("Attendance updated.");

			} else {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Attendance not present!");
			}
		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty attendance not found");
		}
	}

	public ResponseEntity<?> deleteAttendance(int fId, int aId) {

		Optional<Faculty> fexist = fDao.findById(fId);
		
		if(fexist.isPresent()) {
			Optional<Attendance> aexist = aDao.findById(aId);
			
			if(aexist.isPresent()) {
				Attendance attend = aexist.get();
				
				aDao.delete(attend);
				return ResponseEntity.ok("Attendace deleted.");
			}
			else {
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Attendance not found!");
			}
		}
		else {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty not found");
		}
	}

}
