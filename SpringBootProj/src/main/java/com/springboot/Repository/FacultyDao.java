package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Faculty;

import java.util.Optional;

@Repository
public interface FacultyDao extends JpaRepository<Faculty, Integer>, JpaSpecificationExecutor<Faculty> {

	Optional<Faculty> findByfUsername(String fUsername);

}
