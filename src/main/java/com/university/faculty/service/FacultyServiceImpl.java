package com.university.faculty.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.department.model.Department;
import com.university.department.model.DepartmentVO;
import com.university.faculty.model.Faculty;
import com.university.faculty.model.FacultyVO;
import com.university.faculty.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultyRepository facultyRepository;
	
	@Override
	public FacultyVO saveFacultyDetails(FacultyVO faculty) {
		Faculty fac = convertToDTO(faculty);
		FacultyVO facultyVO = convertToVO(facultyRepository.save(fac));
		return facultyVO;
	}

	@Override
	public FacultyVO findFacultyByFacultyId(Integer facultyId) {
		Optional<Faculty> option = facultyRepository.findById(facultyId);
		if(option.isPresent())
			return convertToVO(option.get());
		return null;
	}

	@Override
	public List<FacultyVO> findAllFacultiesByFacultyName(String facultyName) {
		List<FacultyVO> lstFac = new ArrayList<FacultyVO>();
		List<Faculty> lstOut = facultyRepository.findAllFacultiesByFacultyName(facultyName);
		for(Faculty fac : lstOut) {
			lstFac.add(convertToVO(fac));
		}
		return lstFac;
	}

	@Override
	public List<FacultyVO> findallFacultiesByDesignation(String designation) {
		List<FacultyVO> lstFac = new ArrayList<FacultyVO>();
		List<Faculty> lstOut = facultyRepository.findAllFacultiesByDesignation(designation);
		for(Faculty fac : lstOut) {
			lstFac.add(convertToVO(fac));
		}
		return lstFac;
	}
	
	@Override
	public FacultyVO updateFacultyById(Integer id, FacultyVO faculty)   {
		Optional<Faculty> existingFaculty = facultyRepository.findById(id);
	    if (existingFaculty.isPresent())
	    {
	        Faculty fac = convertToDTO(faculty);
	        fac.setFacultyId(id);
	        Faculty updatedFaculty = facultyRepository.save(fac);
	        return convertToVO(updatedFaculty);
	    }
	    return null;
	}

	@Override
	public FacultyVO deleteFaculty(Integer id) {
		Optional<Faculty> existingFaculty = facultyRepository.findById(id);
	    if (existingFaculty.isPresent())
	    {
	        Faculty deletedStudent = existingFaculty.get();
	        facultyRepository.deleteById(id);
	        return convertToVO(deletedStudent);
	    }
	    return null;   
	}
	
	@Override
	public List<FacultyVO> findAllFaculties() {
		List<FacultyVO> lstFac = new ArrayList<FacultyVO>();
		List<Faculty> lstOut = facultyRepository.findAll();
		for(Faculty fac : lstOut) {
			lstFac.add(convertToVO(fac));
		}
		return lstFac;
	}
	
	private FacultyVO convertToVO(Faculty faculty) {
		if(faculty == null)
			return null;
		return new FacultyVO(faculty.getFacultyId(), faculty.getFacultyName(), faculty.getSpecialization(), faculty.getAge(), faculty.getGender(), faculty.getMobileNumber(), faculty.getDesignation(), convertToVO(faculty.getDepartment()));
	}
	
	private Faculty convertToDTO(FacultyVO faculty) {
		if(faculty == null)
			return null;
		return new Faculty(faculty.getFacultyId(), faculty.getFacultyName(), faculty.getSpecialization(), faculty.getAge(), faculty.getGender(), faculty.getMobileNumber(), faculty.getDesignation(), convertToDTO(faculty.getDepartment()));
	}
	
	private DepartmentVO convertToVO(Department dept) {
		if(dept == null)
			return null;
		return new DepartmentVO(dept.getDepartmentId(), dept.getDepartmentName(),dept.getLocation());
	}
	
	private Department convertToDTO(DepartmentVO dept) {
		if(dept == null)
			return null;
		return new Department(dept.getDepartmentId(), dept.getDepartmentName(),dept.getLocation());
	}

}
