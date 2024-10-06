package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public String storeStudent(Student student) {
		studentRepository.save(student);
		return "Student record saved successfully";
	}
	
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

}
