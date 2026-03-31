package com.springboot.controller;

import com.springboot.DTO.FacultyDTO;
import com.springboot.Responses.APIResponse;
import com.springboot.services.FacultyService;
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

import jakarta.servlet.http.HttpSession;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class FacultyCon {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculty")
    public ResponseEntity<?> getFaculty(@RequestBody Map<String, Object> filter) {

        Map<String, Object> data = facultyService.getAllFaculties(filter);
        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Faculty fetched successfully")
                        .data(data)
                        .build()
        );
    }

    @GetMapping("/faculty/{fId}")
    public ResponseEntity<?> getFacultyById(@PathVariable int fId) {

        FacultyDTO data = facultyService.getFacultyById(fId);
//        return ResponseEntity.ok(APIResponse);
        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Faculty fetched successfully")
                        .data(data)
                        .build()
        );
    }

    @GetMapping("/faculty/ByUsername/{fUsername}")
    public ResponseEntity<?> getFacultyByUsername(@PathVariable String fUsername) {

        FacultyDTO data = facultyService.getFacultyByUsername(fUsername);
        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Faculty fetched successfully")
                        .data(data)
                        .build()
        );
    }

    @PostMapping("/faculty")
    public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty) {

        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/faculty/{fId}")
    public ResponseEntity<?> updateFaculty(@PathVariable int fId, @RequestBody Faculty faculty) {

        return facultyService.updateFaculty(fId, faculty);
    }

    @DeleteMapping("/faculty/{fId}")
    public ResponseEntity<?> deleteFaculty(@PathVariable int fId) {

        return facultyService.deleteFaculty(fId);
    }


    @PutMapping("/faculty/assign/{cId}")
    public ResponseEntity<?> assignCourseToFaculty(@RequestParam int[] fIds, @PathVariable int cId) {

        return facultyService.assignCourseToFaculty(fIds, cId);
    }


    @PutMapping("/faculty/unassign/{fId}/{cId}")
    public ResponseEntity<?> unassignCourses(@PathVariable int fId, @PathVariable int cId) {

        return facultyService.unassignCourses(fId, cId);
    }

    @PostMapping("/faculty/signup")
    public ResponseEntity<?> signup(@RequestBody Faculty faculty) {

        return facultyService.signup(faculty);
    }

    @PostMapping("/faculty/signin")
    public ResponseEntity<?> signin(@RequestBody Faculty faculty, HttpSession session) {

        return facultyService.signin(faculty, session);
    }

}
								