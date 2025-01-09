package com.springboot.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Attendance;

@Repository
public interface AttendanceDao extends JpaRepository<Attendance, Integer>{
	
	@Query("SELECT a FROM Attendance a WHERE a.fId.fId = :fId")
	List<Attendance> findAttendanceByFacultyId(@Param("fId") int fId);
	
}
