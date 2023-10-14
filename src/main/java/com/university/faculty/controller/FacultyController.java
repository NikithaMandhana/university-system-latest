package com.university.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.university.faculty.model.FacultyVO;
import com.university.faculty.service.FacultyServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FacultyController {
	
	@Autowired
	FacultyServiceImpl facultyService;
	
	@PostMapping("/faculty/save")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN', 'USER_FACULTY')")
	public ResponseEntity<FacultyVO> saveFaculty(@RequestBody FacultyVO faculty)
	{
		FacultyVO fac = facultyService.saveFacultyDetails(faculty);
		return new ResponseEntity<FacultyVO>(fac, HttpStatus.OK);
	}
	
	@GetMapping("/faculty/find/{id}")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN', 'USER_FACULTY')")
	public ResponseEntity<?> findFaculty(@PathVariable("id") Integer id)
	{
		FacultyVO faculty = facultyService.findFacultyByFacultyId(id);
		if(faculty != null)
			return new ResponseEntity<FacultyVO>(faculty, HttpStatus.OK);
		return new ResponseEntity<>("Faculty not found", HttpStatus.BAD_REQUEST);
	}
	
    @PutMapping("/faculty/update/{id}")
    @PreAuthorize("hasAnyAuthority('USER_ADMIN', 'USER_FACULTY')")
    public ResponseEntity<?> updateFaculty(@PathVariable("id") Integer id, @RequestBody FacultyVO faculty)
    {
        FacultyVO updatedFaculty = facultyService.updateFacultyById(id, faculty);
        if (updatedFaculty != null)
	        return new ResponseEntity<>(updatedFaculty, HttpStatus.OK);
	    return new ResponseEntity<>("Faculty not found", HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/faculty/delete/{id}")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN', 'USER_FACULTY')")
	public ResponseEntity<?> deleteFaculty(@PathVariable("id") Integer id)
	{
		FacultyVO deletedFaculty = facultyService.deleteFaculty(id);
		if (deletedFaculty != null) 
	        return new ResponseEntity<>(deletedFaculty, HttpStatus.OK);
	    return new ResponseEntity<>("Faculty not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/faculty/facultyDetails")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN', 'USER_FACULTY')")
	public ResponseEntity<List<FacultyVO>> faculties() {
		List<FacultyVO> faculties = facultyService.findAllFaculties();
		return new ResponseEntity<List<FacultyVO>>(faculties, HttpStatus.OK);
	}
	
    @GetMapping("/faculty/facultyProfile")
    @PreAuthorize("hasAnyAuthority('USER_ADMIN', 'USER_FACULTY')")
    public String facultyProfile() {
        return "Welcome to Faculty Profile";
    }
}
