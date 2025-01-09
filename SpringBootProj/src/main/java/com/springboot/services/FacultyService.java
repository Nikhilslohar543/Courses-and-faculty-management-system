package com.springboot.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.DAO.CourseAssignmentDao;
import com.springboot.DAO.CoursesDao;
import com.springboot.DAO.FacultyDao;
import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;

import jakarta.servlet.http.HttpSession;

@Service
public class FacultyService {

	@Autowired
	private FacultyDao fDao;

	@Autowired
	private CoursesDao cDao;

	@Autowired
	private CourseAssignmentDao caDao;

	public ResponseEntity<?> getFaculty() {

		List<Faculty> existing = fDao.findAll();

		return ResponseEntity.ok(existing);
	}

	public ResponseEntity<?> getFacultyById(int fId) {

		Optional<Faculty> exist = fDao.findById(fId);
		if (exist.isPresent()) {
			return ResponseEntity.ok(exist);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not Found!");
		}
	}

	public ResponseEntity<?> getFacultyByUsername(String fUsername) {

		Faculty faculty = fDao.findByfUsername(fUsername);

		if (faculty != null) {
			return ResponseEntity.ok(faculty);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
		}
	}

	public ResponseEntity<?> addFaculty(Faculty faculty) {

		Optional<Faculty> fexist = fDao.findById(faculty.getfId());

		if (fexist.isEmpty()) {

			if (fDao.findByfUsername(faculty.getfUsername()) == null) {

				fDao.save(faculty);
				return ResponseEntity.ok("New user added with " + faculty.getfUsername() + " username.");

			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username already exists!");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials!");
		}

	}

	public ResponseEntity<?> updateFaculty(int fId, Faculty faculty) {

		Optional<Faculty> exist = fDao.findById(fId);

		if (exist.isPresent()) {

			Faculty newFaculty = exist.get();

			Faculty facultyWithSameUsername = fDao.findByfUsername(faculty.getfUsername());
			if (facultyWithSameUsername != null && facultyWithSameUsername.getfId() != fId) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists!");
			}
			newFaculty.setfId(faculty.getfId());
			newFaculty.setfName(faculty.getfName());
			newFaculty.setfEmail(faculty.getfEmail());
			newFaculty.setfRole(faculty.getfRole());
			newFaculty.setGender(faculty.getGender());
			newFaculty.setMobno(faculty.getMobno());
			newFaculty.setfUsername(faculty.getfUsername());
			newFaculty.setfPassword(faculty.getfPassword());
			newFaculty.setStatus(faculty.getStatus());

			fDao.save(newFaculty);

			return ResponseEntity.ok("Faculty details updated.");

		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faculty not found!");
		}
	}

	public ResponseEntity<?> deleteFaculty(int fId) {

		Optional<Faculty> exist = fDao.findById(fId);
		if (exist.isPresent()) {

			Faculty faculty = exist.get();
			fDao.delete(faculty);

			return ResponseEntity.ok("faculty deleted");
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("faculty not found!");
		}
	}

//	public ResponseEntity<?> assignCourseToFaculty(int fId, int cId) {
//
//		Optional<Courses> cexist = cDao.findById(cId);
//		Optional<Faculty> fexist = fDao.findById(fId);
//
//		if (cexist.isPresent() && fexist.isPresent()) {
//			Courses course = cexist.get();
//			Faculty faculty = fexist.get();
//
//			if (caDao.existsByCouIdAndFacId(course, faculty)) {
//				return ResponseEntity.status(HttpStatus.CONFLICT).body("Course is already assigned to faculty!");
//			} else {
//				CourseAssignment assign = new CourseAssignment();
//
//				assign.setCouId(course);
//				assign.setFacId(faculty);
//
//				caDao.save(assign);
//
//				return ResponseEntity.ok("Course assigned to faculty.");
//			}
//
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Either the course or the faculty does not exist.");
//		}
//
//	}

	public ResponseEntity<?> assignCourseToFaculty(int fIds[], int cId) {

		Optional<Courses> cexist = cDao.findById(cId);
		if (!cexist.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course does not exist.");
		}

		Courses course = cexist.get();
		for (int fId : fIds) {
			Optional<Faculty> fexist = fDao.findById(fId);

			if (fexist.isPresent()) {
				Faculty faculty = fexist.get();

				if (caDao.existsByCouIdAndFacId(course, faculty)) {
					System.out.println("Course already assigned to faculty with ID: " + fId);
					continue;
				} else {
					CourseAssignment assign = new CourseAssignment();
					assign.setCouId(course);
					assign.setFacId(faculty);
					caDao.save(assign);
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty with ID: " + fId + " does not exist.");
			}
		}
		return ResponseEntity.ok("Course assigned to selected faculties (excluding already assigned ones).");

	}

	public ResponseEntity<?> unassignCourses(int fId, int cId) {

		Optional<Courses> cexist = cDao.findById(cId);
		Optional<Faculty> fexist = fDao.findById(fId);

		if (cexist.isPresent() && fexist.isPresent()) {
			Courses course = cexist.get();
			Faculty faculty = fexist.get();

			Optional<CourseAssignment> caexist = caDao.getByCouIdAndFacId(course, faculty);

			if (caexist.isPresent()) {
				CourseAssignment unassign = caexist.get();

				caDao.delete(unassign);

				return ResponseEntity
						.ok(Map.of("success", true, "message", "Course has been unassigned from faculty."));

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Course is not assigned to spcified faculty!");
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Either the course or the faculty does not exist.");
		}

	}

	public ResponseEntity<?> signup(Faculty faculty) {

		if (faculty != null) {

			if (fDao.findByfUsername(faculty.getfUsername()) == null) {

				fDao.save(faculty);
				return ResponseEntity.ok("Registered with " + faculty.getfUsername() + " username.");

			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username already exists!");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials!");
		}
	}

	public ResponseEntity<?> signin(Faculty faculty, HttpSession session) {

		Faculty existing = fDao.findByfUsername(faculty.getfUsername());

		if (existing != null && existing.getfUsername().equals(faculty.getfUsername())
				&& existing.getfPassword().equals(faculty.getfPassword())) {

			session.setAttribute("fId", existing.getfId());

			return ResponseEntity
					.ok(new Faculty(existing.getfId(), existing.getfName(), existing.getfEmail(), existing.getfRole(),
							existing.getfUsername(), existing.getMobno(), existing.getStatus(), existing.getGender(),
							existing.getfPassword(), existing.getCourseAssignment(), existing.getAttendance()));

		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found!");

		}

	}

}
