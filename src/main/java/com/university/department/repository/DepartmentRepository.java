package com.university.department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.department.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	List<Department> findDepartmentByDepartmentId(Integer departmentId);
	
	List<Department> findAllDepartmentsByDepartmentName(String departmentName);
	
	List<Department> findAllDepartmentsByLocation(String location);
	
}
