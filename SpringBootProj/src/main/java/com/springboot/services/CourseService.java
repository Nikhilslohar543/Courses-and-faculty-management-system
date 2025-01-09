package com.springboot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.DAO.CourseAssignmentDao;
import com.springboot.DAO.CoursesDao;
import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;

@Service
public class CourseService {

	@Autowired
	private CoursesDao cDao;

	@Autowired
	private CourseAssignmentDao caDao;

	public List<Courses> getAllCourses() {

		return cDao.findAll();
	}
	
	public List<Faculty> getFacultyByCourseId(int cId){
		
		Courses course = cDao.findById(cId).orElseThrow(() -> new RuntimeException("Course not found"));

	    List<CourseAssignment> assignments = caDao.findByCouId(course);

	    return assignments.stream()
	                      .map(CourseAssignment::getFacId)
	                      .collect(Collectors.toList());
	}
	
	public List<Courses> getCourseByfId(int fId) {
        List<CourseAssignment> assignments = caDao.findByFacId_fId(fId);

        return assignments.stream()
                .map(CourseAssignment::getCouId)
                .collect(Collectors.toList());
    }

	public ResponseEntity<?> getCourseBycId(int cId) {

		Optional<Courses> exist = cDao.findById(cId);

		if (exist.isPresent()) {
			Courses course = exist.get();

			return ResponseEntity.ok(course);
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course not found!");
		}

	}

	public ResponseEntity<?> addCourse(Courses course) {

		Courses exist = cDao.findBycName(course.getcName());
		if (exist == null && course != null) {

			cDao.save(course);
			return ResponseEntity.ok("Course added.");
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong");
		}
	}

	public ResponseEntity<?> updateCourse(Courses course) {

		Optional<Courses> exist = cDao.findById(course.getcId());
		if (exist.isPresent()) {

			Courses newCourse = exist.get();

			newCourse.setcId(course.getcId());
			newCourse.setcName(course.getcName());
			newCourse.setcDescription(course.getcDescription());
			newCourse.setcDuration(course.getcDuration());
			newCourse.setStartDate(course.getStartDate());
			newCourse.setEndDate(course.getEndDate());

			cDao.save(newCourse);
			return ResponseEntity.ok("course updated.");
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("course not found!");
		}
	}

	public ResponseEntity<?> deleteCourse(int cId) {

		Optional<Courses> exist = cDao.findById(cId);
		if (exist.isPresent()) {
			Courses course = exist.get();

			cDao.delete(course);
			return ResponseEntity.ok("course deleted.");
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("course not found");
		}
	}


}
