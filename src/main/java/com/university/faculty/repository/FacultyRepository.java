package com.university.faculty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.faculty.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

	List<Faculty> findFacultyByFacultyId(Integer facultyId);
	
	List<Faculty> findAllFacultiesByFacultyName(String facultyName);
	
	List<Faculty> findAllFacultiesByDesignation(String designation);
}
