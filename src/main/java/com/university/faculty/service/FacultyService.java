package com.university.faculty.service;

import java.util.List;

import com.university.faculty.model.FacultyVO;

public interface FacultyService {

	FacultyVO findFacultyByFacultyId(Integer facultyId);
	
	List<FacultyVO> findAllFacultiesByFacultyName(String facultyName);
	
	List<FacultyVO> findallFacultiesByDesignation(String designation);
	
	FacultyVO saveFacultyDetails(FacultyVO faculty);
	
	FacultyVO updateFacultyById(Integer id, FacultyVO faculty);
	
	FacultyVO deleteFaculty(Integer id);
	
	List<FacultyVO> findAllFaculties();
}
