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

import com.springboot.Entity.Attendance;
import com.springboot.services.AttendanceSer;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class AttendanceCon {

	@Autowired
	private AttendanceSer aSer;
	
	@GetMapping("/attendance/{fId}")
	public List<Attendance> getAttendance(@PathVariable int fId){
		
		return aSer.getAttendance(fId);
	}
	
	@GetMapping("/attendance/{fId}/{aId}")
	public ResponseEntity<?> getAttendanceById(@PathVariable int fId, @PathVariable int aId){
		
		return aSer.getAttendanceById(fId, aId);
	}
	
	@PostMapping("/attendance/{fId}")
	public ResponseEntity<?> addAttendance(@PathVariable int fId,@RequestBody Attendance attendance){
		
		return aSer.addAttendance(fId,attendance);
	}
	
	@PutMapping("/attendance/{fId}")
	public ResponseEntity<?> updateAttendance(@PathVariable int fId,@RequestBody Attendance attendance){
		
		return aSer.updateAttendance(fId,attendance);
	}
	
	@DeleteMapping("/attendance/{fId}/{aId}")
	public ResponseEntity<?> deleteAttendance(@PathVariable int fId,@PathVariable int aId){
		
		return aSer.deleteAttendance(fId,aId);
	}
	
}
