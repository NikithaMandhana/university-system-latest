package com.university.department.service;

import java.util.List;

import com.university.department.model.DepartmentVO;

public interface DepartmentService {

	DepartmentVO findDepartmentByDepartmentId(Integer departmentId);
	
	List<DepartmentVO> findAllDepartmentsByDepartmentName(String departmentName);
	
	List<DepartmentVO> findAllDepartmentsByLocation(String location);
	
	DepartmentVO saveDepartmentDetails(DepartmentVO department);
	
	DepartmentVO updateDepartmentById(Integer id, DepartmentVO department);
	
	DepartmentVO deleteDepartment(Integer id);
	
	List<DepartmentVO> findAllDepartments();
	
}
