package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Faculty;

@Repository
public interface FacultyDao extends JpaRepository<Faculty, Integer>, JpaSpecificationExecutor<Faculty> {

	Faculty findByfUsername(String fUsername);

}
