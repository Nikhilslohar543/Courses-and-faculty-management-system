package com.springboot.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;

@Repository
public interface CourseAssignmentDao extends JpaRepository<CourseAssignment, Integer>, JpaSpecificationExecutor<Faculty> {

    boolean existsByCoursesIdAndFacultyId(Courses couId, Faculty facId);

    Optional<CourseAssignment> getByCoursesIdAndFacultyId(Courses couId, Faculty facId);
        
    List<CourseAssignment> findByFacultyId_fId(int fId);
    
    List<CourseAssignment> findByCoursesId(Courses course);
    
}

