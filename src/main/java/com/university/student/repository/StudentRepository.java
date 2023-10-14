package com.university.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findStudentByStudentId(Integer studentId);
	
	List<Student> findAllStudentByStudentName(String studentName);
	
	List<Student> findAllStudentsByEnrollmentYear(Integer enrollmentYear);
}
