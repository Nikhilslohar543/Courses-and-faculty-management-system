package com.springboot.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Faculty;
import com.springboot.services.FacultyService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class FacultyCon {

	@Autowired
	private FacultyService fSer;
	
	@GetMapping("/faculty")
	public ResponseEntity<?> getFaculty(){
		
		return fSer.getFaculty();
	}
	
	@GetMapping("/faculty/{fId}")
	public ResponseEntity<?> getFacultyById(@PathVariable int fId){
		
		return fSer.getFacultyById(fId);
	}
	
	@GetMapping("/faculty/ByUsername/{fUsername}")
	public ResponseEntity<?> getFacultyByUsername(@PathVariable String fUsername){
		System.out.println(fUsername);
		return fSer.getFacultyByUsername(fUsername);
	}
	
	@PostMapping("/faculty")
	public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty){
		
		return fSer.addFaculty(faculty);
	}
	
	@PutMapping("/faculty/{fId}")
	public ResponseEntity<?> updateFaculty(@PathVariable int fId,@RequestBody Faculty faculty){
		
		return fSer.updateFaculty(fId,faculty);
	}
	
	@DeleteMapping("/faculty/{fId}")
	public ResponseEntity<?> deleteFaculty(@PathVariable int fId){
		
		return fSer.deleteFaculty(fId);
	}

	
	@PutMapping("/faculty/assign/{cId}")
	public ResponseEntity<?> assignCourseToFaculty(@RequestParam int[] fIds, @PathVariable int cId) {

	    return fSer.assignCourseToFaculty(fIds, cId);
	}

	
	@PutMapping("/faculty/unassign/{fId}/{cId}")
	public ResponseEntity<?> unassignCourses(@PathVariable int fId, @PathVariable int cId){
		
		return fSer.unassignCourses(fId, cId);
	}						
	
	@PostMapping("/faculty/signup")
	public ResponseEntity<?> signup(@RequestBody Faculty faculty){
		
		return fSer.signup(faculty);
	}
	
	@PostMapping("/faculty/signin")
	public ResponseEntity<?> signin(@RequestBody Faculty faculty, HttpSession session){
		
		return fSer.signin(faculty,session);
	}
	
}
								