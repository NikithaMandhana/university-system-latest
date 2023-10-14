package com.university.student.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.university.department.model.DepartmentVO;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentVO {
	
	Integer studentId;
	
	String studentName;
	
	String fatherName;
	
	Integer age;
	
	String gender;
	
	Long mobileNumber;
	
	Integer enrollmentYear;
	
	DepartmentVO department;
	
	public StudentVO() {}
	
	public StudentVO(Integer studentId, String studentName, String fatherName, Integer age, String gender,
			Long mobileNumber, Integer enrollmentYear, DepartmentVO department) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.enrollmentYear = enrollmentYear;
		this.department = department;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(Integer enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

}
