package com.springboot.services;

import com.springboot.DTO.FacultyDTO;
import com.springboot.Entity.Faculty;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

public interface FacultyService {

    ResponseEntity<?> getFaculty();


    FacultyDTO getFacultyById(int fId);


    ResponseEntity<?> getFacultyByUsername(String fUsername);


    ResponseEntity<?> addFaculty(Faculty faculty);


    ResponseEntity<?> updateFaculty(int fId, Faculty faculty);


    ResponseEntity<?> deleteFaculty(int fId);


    ResponseEntity<?> assignCourseToFaculty(int[] fIds, int cId);


    ResponseEntity<?> unassignCourses(int fId, int cId);


    ResponseEntity<?> signup(Faculty faculty);


    ResponseEntity<?> signin(Faculty faculty, HttpSession session);


}
