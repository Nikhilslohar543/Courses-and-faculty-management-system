package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;
import com.springboot.services.CourseService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class CoursesCon {

	@Autowired
	private CourseService cSer;

	@GetMapping("/course")
	public List<Courses> getAllCourses(){
		
		return cSer.getAllCourses();
	}
	
	@GetMapping("/course/faculty/{cId}")
	public List<Faculty> getFacultyByCourseId(@PathVariable int cId){
		return cSer.getFacultyByCourseId(cId);
	}
	
	@GetMapping("/course/{fId}")
    public List<Courses> getCourseByfId(@PathVariable int fId) {
        return cSer.getCourseByfId(fId);
    }
	
	@GetMapping("/course/ById/{cId}")
	public ResponseEntity<?> getCourseBycId(@PathVariable int cId){
		
		return cSer.getCourseBycId(cId);
	}

	@PostMapping("/course")
	public ResponseEntity<?> addCourse(@RequestBody Courses course) {

		return cSer.addCourse(course);
	}

	@PutMapping("/course")
	public ResponseEntity<?> updateCourse(@RequestBody Courses course) {

		return cSer.updateCourse(course);
	}

	@DeleteMapping("/course/{cId}")
	public ResponseEntity<?> deleteCourse(@PathVariable int cId) {

		return cSer.deleteCourse(cId);
	}
}
