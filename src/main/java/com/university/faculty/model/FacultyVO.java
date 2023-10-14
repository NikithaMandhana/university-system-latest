package com.university.faculty.model;

import com.university.department.model.DepartmentVO;

public class FacultyVO {
	
	Integer facultyId;
	
	String facultyName;
	
	String specialization;
	
	Integer age;
	
	String gender;
	
	String mobileNumber;
	
	String designation;
	
	DepartmentVO department;

	public FacultyVO() {}

	public FacultyVO(Integer facultyId, String facultyName, String specialization, Integer age, String gender,
			String mobileNumber, String designation, DepartmentVO department) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.specialization = specialization;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.designation = designation;
		this.department = department;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

}
