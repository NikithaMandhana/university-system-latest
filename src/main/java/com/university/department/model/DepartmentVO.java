package com.university.department.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentVO {
	Integer departmentId;
	
	String departmentName;
	
	String location;
	
	public DepartmentVO() {}
	
	public DepartmentVO(Integer departmentId, String departmentName, String location) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.location = location;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
