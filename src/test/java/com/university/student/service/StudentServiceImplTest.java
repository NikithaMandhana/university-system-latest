package com.university.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.university.department.model.Department;
import com.university.student.model.Student;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
	
	Student student = new Student(1, "Simran", null, 2000, 
			null, null, null, new Department(null, null, null));
	
	@Test
	void testFindStudentByStudentId()
	{
		assertEquals(student.getStudentId(), 1);	
	}
	
	@Test
	void testFindStudentByStudentName()
	{
		assertEquals(student.getStudentName(), "Simran");	
	}
}
