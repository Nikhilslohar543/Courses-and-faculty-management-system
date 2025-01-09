package com.springboot.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Faculty;

@Repository
public interface FacultyDao extends JpaRepository<Faculty, Integer> {

	Faculty findByfUsername(String fUsername);

}
