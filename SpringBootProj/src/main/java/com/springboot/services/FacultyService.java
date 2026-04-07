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


    FacultyDTO addFaculty(Faculty faculty);


    FacultyDTO updateFaculty(int fId, Faculty faculty);


    String deleteFaculty(int fId);


    String assignCourseToFaculty(int[] fIds, int cId);


    String unassignCourses(int fId, int cId);


    ResponseEntity<?> signup(Faculty faculty);


    ResponseEntity<?> signin(Faculty faculty, HttpSession session);


}
