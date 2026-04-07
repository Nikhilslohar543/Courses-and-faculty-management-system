package com.springboot.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.springboot.Common.CustomQuerySpecification;
import com.springboot.DTO.CourseDTO;
import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;
import com.springboot.Mappers.CourseMapper;
import com.springboot.Responses.CFMSException;

import com.springboot.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.Repository.CourseAssignmentDao;
import com.springboot.Repository.CoursesDao;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursesDao cDao;

    @Autowired
    private CourseAssignmentDao caDao;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Map<String, Object> getAllCourses(Map<String, Object> filter) {

        CustomQuerySpecification<Courses> specification =
                CustomQuerySpecification.getInstance(filter);

        List<Courses> courseList = cDao.findAll(specification);

        List<CourseDTO> list = courseList.stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());

        Map<String, Object> data = new HashMap<>();
        data.put("data", list);

        return data;
    }

    @Override
    public List<Faculty> getFacultyByCourseId(int cId) {

        Courses course = cDao.findById(cId)
                .orElseThrow(() -> new CFMSException("Course not found!", HttpStatus.NOT_FOUND));

        List<CourseAssignment> assignments = caDao.findByCoursesId(course);

        return assignments.stream()
                .map(CourseAssignment::getFacultyId)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByfId(int fId) {

        List<CourseAssignment> assignments = caDao.findByFacultyId_fId(fId);

        return assignments.stream()
                .map(CourseAssignment::getCoursesId)
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseBycId(int cId) {

        Courses course = cDao.findById(cId)
                .orElseThrow(() -> new CFMSException("Course not found!", HttpStatus.NOT_FOUND));

        return courseMapper.toDTO(course);
    }

    @Override
    public CourseDTO addCourse(Courses course) {

        if (course == null) {
            throw new CFMSException("Invalid course data!", HttpStatus.BAD_REQUEST);
        }

        Courses exist = cDao.findBycName(course.getcName());

        if (exist != null) {
            throw new CFMSException("Course already exists!", HttpStatus.FOUND);
        }

        Courses saved = cDao.save(course);

        return courseMapper.toDTO(saved);
    }

    @Override
    public CourseDTO updateCourse(int cId, Courses course) {

        Courses existing = cDao.findById(cId)
                .orElseThrow(() -> new CFMSException("Course not found!", HttpStatus.NOT_FOUND));

        CourseDTO dto = courseMapper.toDTO(course);
        courseMapper.updateCourse(dto, existing);

        Courses updated = cDao.save(existing);

        return courseMapper.toDTO(updated);
    }

    @Override
    public String deleteCourse(int cId) {

        Courses course = cDao.findById(cId)
                .orElseThrow(() -> new CFMSException("Course not found!", HttpStatus.NOT_FOUND));

        cDao.delete(course);

        return "Course deleted successfully";
    }
}