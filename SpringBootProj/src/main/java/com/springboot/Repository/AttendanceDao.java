package com.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Attendance;

@Repository
public interface AttendanceDao extends JpaRepository<Attendance, Integer>{

    List<Attendance> findByFacultyId_fId(int fId);

}
