package com.university.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.department.model.Department;
import com.university.department.model.DepartmentVO;
import com.university.student.model.Student;
import com.university.student.model.StudentVO;
import com.university.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public StudentVO saveStudentDetails(StudentVO student) {
		Student stud = convertToDTO(student);
		StudentVO studentVO = convertToVO(studentRepository.save(stud));
		return studentVO;
	}

	@Override
	public StudentVO findStudentByStudentId(Integer studentId) {
		Optional<Student> option = studentRepository.findById(studentId);
		if(option.isPresent())
			return convertToVO(option.get());
		return null;
	}

	@Override
	public List<StudentVO> findStudentByStudentName(String studentName) {
		List<StudentVO> lstSt = new ArrayList<StudentVO>();
		List<Student> lstOut = studentRepository.findAllStudentByStudentName(studentName);
		for(Student st : lstOut) {
			lstSt.add(convertToVO(st));
		}
		return lstSt;
	}

	@Override
	public List<StudentVO> findAllStudentsByEnrollmentYear(Integer enrollmentYear) {
		List<StudentVO> lstSt = new ArrayList<StudentVO>();
		List<Student> lstOut = studentRepository.findAllStudentsByEnrollmentYear(enrollmentYear);
		for(Student st : lstOut) {
			lstSt.add(convertToVO(st));
		}
		return lstSt;
	}

	@Override
	public StudentVO updateStudentById(Integer id, StudentVO student) {
	    Optional<Student> existingStudent = studentRepository.findById(id);
	    if (existingStudent.isPresent())
	    {
	        Student stud = convertToDTO(student);
	        stud.setStudentId(id);
	        Student updatedStudent = studentRepository.save(stud);
	        return convertToVO(updatedStudent);
	    }
	    return null;
	}
	
	@Override
	public StudentVO deleteStudent(Integer id) {
	    Optional<Student> existingStudent = studentRepository.findById(id);
	    if (existingStudent.isPresent())
	    {
	        Student deletedStudent = existingStudent.get();
	        studentRepository.deleteById(id);
	        return convertToVO(deletedStudent);
	    }
	    return null;
	}
	
	@Override
	public List<StudentVO> findAllStudents() {
		List<StudentVO> lstSt = new ArrayList<StudentVO>();
		List<Student> lstOut = studentRepository.findAll();
		for(Student st : lstOut) {
			lstSt.add(convertToVO(st));
		}
		return lstSt;
	}

	private StudentVO convertToVO(Student student) {
		if(student == null)
			return null;
		return new StudentVO(student.getStudentId(), student.getStudentName(), student.getFatherName(), student.getAge(), student.getGender(), student.getMobileNumber(), student.getEnrollmentYear(), convertToVO(student.getDepartment()));
	}
	
	private Student convertToDTO(StudentVO student) {
		if(student == null)
			return null;
	return new Student(student.getStudentId(), student.getStudentName(), student.getFatherName(), student.getAge(), student.getGender(), student.getMobileNumber(), student.getEnrollmentYear(), convertToDTO(student.getDepartment()));
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
