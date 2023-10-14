package com.university.department.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.department.model.Department;
import com.university.department.model.DepartmentVO;
import com.university.department.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentVO saveDepartmentDetails(DepartmentVO department) {
		Department dept = convertToDTO(department);
		DepartmentVO departmentVO = convertToVO(departmentRepository.save(dept));
		return departmentVO;
	}

	@Override
	public DepartmentVO findDepartmentByDepartmentId(Integer departmentId) {
		Optional<Department> option = departmentRepository.findById(departmentId);
		if(option.isPresent())
			return convertToVO(option.get());
		return null;
	}

	@Override
	public List<DepartmentVO> findAllDepartmentsByDepartmentName(String departmentName) {
		List<DepartmentVO> lstDept = new ArrayList<DepartmentVO>();
		List<Department> lstOut = departmentRepository.findAllDepartmentsByDepartmentName(departmentName);
		for(Department dept : lstOut) {
			lstDept.add(convertToVO(dept));
		}
		return lstDept;
	}

	@Override
	public List<DepartmentVO> findAllDepartmentsByLocation(String location) {
		List<DepartmentVO> lstDept = new ArrayList<DepartmentVO>();
		List<Department> lstOut = departmentRepository.findAllDepartmentsByLocation(location);
		for(Department dept : lstOut) {
			lstDept.add(convertToVO(dept));
		}
		return lstDept;
	}

	@Override
	public DepartmentVO updateDepartmentById(Integer id, DepartmentVO department) {
	    Optional<Department> existingDepartment = departmentRepository.findById(id);
	    if (existingDepartment.isPresent())
	    {
	        Department dept = convertToDTO(department);
	        dept.setDepartmentId(id);
	        Department updatedDepartment = departmentRepository.save(dept);
	        return convertToVO(updatedDepartment);
	    }
	    return null;
	}
	
	@Override
	public DepartmentVO deleteDepartment(Integer id) {
	    Optional<Department> existingDepartment = departmentRepository.findById(id);
	    if (existingDepartment.isPresent())
	    {
	        Department deletedDepartment = existingDepartment.get();
	        departmentRepository.deleteById(id);
	        return convertToVO(deletedDepartment);
	    }
	    return null;
	}
	
	@Override
	public List<DepartmentVO> findAllDepartments() {		
		List<DepartmentVO> lstDept = new ArrayList<DepartmentVO>();
		List<Department> lstOut = departmentRepository.findAll();
		for(Department dept : lstOut) {
			lstDept.add(convertToVO(dept));
		}
		return lstDept;
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
