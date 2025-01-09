package com.springboot.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;

@Repository
public interface CoursesDao extends JpaRepository<Courses, Integer>{
	
	List<Courses> findBycId(Faculty faculty);

	Courses findBycName(String cName);
	
}
