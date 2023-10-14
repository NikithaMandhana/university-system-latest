package com.university.department.controller;

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

import com.university.department.model.DepartmentVO;
import com.university.department.service.DepartmentServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImpl departmentService;
	
	@PostMapping("/department/saveDetails")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN')")
	public ResponseEntity<DepartmentVO> saveDepartment(@RequestBody DepartmentVO department)
	{
		DepartmentVO dept = departmentService.saveDepartmentDetails(department);
		return new ResponseEntity<DepartmentVO>(dept, HttpStatus.OK);
	}
	
	@GetMapping("/department/find/{id}")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN', 'USER_STUDENT', 'USER_FACULTY')")
	public ResponseEntity<?> findDepartment(@PathVariable("id") Integer id)
	{
		DepartmentVO department = departmentService.findDepartmentByDepartmentId(id);
		if(department != null)
			return new ResponseEntity<DepartmentVO>(department, HttpStatus.OK);
		return new ResponseEntity<>("Department not found", HttpStatus.BAD_REQUEST);
	}
	
    @PutMapping("/department/update/{id}")
    @PreAuthorize("hasAnyAuthority('USER_ADMIN')")
    public ResponseEntity<?> updateDepartment(@PathVariable("id") Integer id, @RequestBody DepartmentVO department)
    {
        DepartmentVO updatedDepartment = departmentService.updateDepartmentById(id, department);
	    if (updatedDepartment != null)
	        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
	    return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/department/delete/{id}")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN')")
	public ResponseEntity<?> deleteDepartment(@PathVariable("id") Integer id)
	{
		DepartmentVO deletedDepartment = departmentService.deleteDepartment(id);
		if(deletedDepartment != null)
			return new ResponseEntity<>(deletedDepartment, HttpStatus.OK);
		return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);	
	}
	
	@GetMapping("/department/departments")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN', 'USER_STUDENT', 'USER_FACULTY')")
	public ResponseEntity<List<DepartmentVO>> departments()
	{
		List<DepartmentVO> departments = departmentService.findAllDepartments();
			return new ResponseEntity<List<DepartmentVO>>(departments, HttpStatus.OK);
	}
	
}
