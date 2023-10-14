package com.university.student.controller;

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

import com.university.student.model.StudentVO;
import com.university.student.service.StudentServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@Api(value = "Student Api", protocols = "http")
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentService;
	
	@PostMapping("/student/saveDetails")
	@PreAuthorize("hasAnyAuthority('USER_ADMIN')")
	public ResponseEntity<StudentVO> saveStudent(@RequestBody StudentVO student)
	{
		StudentVO stud = studentService.saveStudentDetails(student);
		return new ResponseEntity<StudentVO>(stud, HttpStatus.OK);
	}

	@GetMapping("/student/find/{id}")
	@PreAuthorize("hasAnyAuthority('USER_STUDENT', 'USER_ADMIN')")
	public ResponseEntity<?> findStudent(@PathVariable("id") Integer id)
	{
		StudentVO student = studentService.findStudentByStudentId(id);
		if(student != null)
			return new ResponseEntity<StudentVO>(student, HttpStatus.OK);
		return new ResponseEntity<>("Student not found", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/student/update/{id}")
	@PreAuthorize("hasAnyAuthority('USER_STUDENT', 'USER_ADMIN')")
	public ResponseEntity<?> updateStudent(@PathVariable("id") Integer id, @RequestBody StudentVO student)
	{
	    StudentVO updatedStudent = studentService.updateStudentById(id, student);
	    if (updatedStudent != null)
	        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	    return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/student/delete/{id}")
	@PreAuthorize("hasAuthority('USER_ADMIN')")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id) {
	    StudentVO deletedStudent = studentService.deleteStudent(id);
	    if (deletedStudent != null) 
	        return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
	    return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/student/studentDetails")
	@PreAuthorize("hasAnyAuthority('USER_STUDENT', 'USER_ADMIN')")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<StudentVO>> students() {
		List<StudentVO> students = studentService.findAllStudents();
		return new ResponseEntity<List<StudentVO>>(students, HttpStatus.OK);
	}
	
    @GetMapping("/student/studentProfile")
    @PreAuthorize("hasAnyAuthority('USER_STUDENT','USER_ADMIN')")
    public String studentProfile() {
    	
        return "Welcome to Student Profile";
    }

}
