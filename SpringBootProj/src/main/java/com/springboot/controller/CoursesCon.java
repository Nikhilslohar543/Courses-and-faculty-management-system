package com.springboot.controller;

import java.util.List;
import java.util.Map;

import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Faculty;
import com.springboot.Responses.APIResponse;
import com.springboot.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.DTO.CourseDTO;
import com.springboot.Entity.Courses;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class CoursesCon {

    @Autowired
    private CourseService cSer;

    // Get All Courses (with filter like faculty)
    @GetMapping("/course")
    public ResponseEntity<?> getAllCourses(@RequestBody Map<String, Object> filter) {

        Map<String, Object> data = cSer.getAllCourses(filter);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Courses fetched successfully")
                        .data(data)
                        .build()
        );
    }

    // Get Faculty by Course ID
    @GetMapping("/course/faculty/{cId}")
    public ResponseEntity<?> getFacultyByCourseId(@PathVariable int cId) {

        List<Faculty> data = cSer.getFacultyByCourseId(cId);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Faculty list fetched successfully")
                        .data(data)
                        .build()
        );
    }

    // Get Courses by Faculty ID
    @GetMapping("/course/{fId}")
    public ResponseEntity<?> getCourseByfId(@PathVariable int fId) {

        List<CourseDTO> data = cSer.getCourseByfId(fId);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Courses fetched successfully")
                        .data(data)
                        .build()
        );
    }

    // Get Course by Course ID
    @GetMapping("/course/ById/{cId}")
    public ResponseEntity<?> getCourseBycId(@PathVariable int cId) {

        CourseDTO data = cSer.getCourseBycId(cId);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Course fetched successfully")
                        .data(data)
                        .build()
        );
    }

    // Add Course
    @PostMapping("/course")
    public ResponseEntity<?> addCourse(@RequestBody Courses course) {

        CourseDTO data = cSer.addCourse(course);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Course saved successfully")
                        .data(data)
                        .build()
        );
    }

    // Update Course
    @PutMapping("/course/{cId}")
    public ResponseEntity<?> updateCourse(@PathVariable int cId, @RequestBody Courses course) {

        CourseDTO data = cSer.updateCourse(cId, course);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Course updated successfully")
                        .data(data)
                        .build()
        );
    }

    // Delete Course
    @DeleteMapping("/course/{cId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int cId) {

        String msg = cSer.deleteCourse(cId);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg(msg)
                        .build()
        );
    }
}