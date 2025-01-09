package com.springboot.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;

@Repository
public interface CourseAssignmentDao extends JpaRepository<CourseAssignment, Integer> {

    boolean existsByCouIdAndFacId(Courses couId, Faculty facId);

    Optional<CourseAssignment> getByCouIdAndFacId(Courses couId, Faculty facId);
        
    List<CourseAssignment> findByFacId_fId(int fId);
    
    List<CourseAssignment> findByCouId(Courses course);
    
}

