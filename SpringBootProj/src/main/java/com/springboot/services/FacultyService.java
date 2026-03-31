package com.springboot.services;

import com.springboot.DTO.FacultyDTO;
import com.springboot.Entity.Faculty;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Objects;

public interface FacultyService {

    Map<String, Object> getAllFaculties(Map<String, Object> filter);


    FacultyDTO getFacultyById(int fId);


    FacultyDTO getFacultyByUsername(String fUsername);


    ResponseEntity<?> addFaculty(Faculty faculty);


    ResponseEntity<?> updateFaculty(int fId, Faculty faculty);


    ResponseEntity<?> deleteFaculty(int fId);


    ResponseEntity<?> assignCourseToFaculty(int[] fIds, int cId);


    ResponseEntity<?> unassignCourses(int fId, int cId);


    ResponseEntity<?> signup(Faculty faculty);


    ResponseEntity<?> signin(Faculty faculty, HttpSession session);


}
