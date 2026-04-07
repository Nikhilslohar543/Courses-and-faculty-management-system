package com.springboot.services;

import java.util.List;
import java.util.Map;

import com.springboot.DTO.CourseDTO;
import com.springboot.Entity.Courses;
import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Faculty;

public interface CourseService {

    Map<String, Object> getAllCourses(Map<String, Object> filter);

    List<Faculty> getFacultyByCourseId(int cId);

    List<CourseDTO> getCourseByfId(int fId);

    CourseDTO getCourseBycId(int cId);

    CourseDTO addCourse(Courses course);

    CourseDTO updateCourse(int cId, Courses course);

    String deleteCourse(int cId);

}