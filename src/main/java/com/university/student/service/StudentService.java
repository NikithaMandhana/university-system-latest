package com.university.student.service;

import java.util.List;

import com.university.student.model.StudentVO;

public interface StudentService {

	StudentVO findStudentByStudentId(Integer studentId);
	
	List<StudentVO> findStudentByStudentName(String studentName);
	
	List<StudentVO> findAllStudentsByEnrollmentYear(Integer enrollmentYear);
	
	StudentVO saveStudentDetails(StudentVO student);
	
	StudentVO updateStudentById(Integer id, StudentVO student);
	
	StudentVO deleteStudent(Integer id);
	
	List<StudentVO> findAllStudents();
}
