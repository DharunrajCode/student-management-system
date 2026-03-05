package com.project.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.studentManagement.dto.StudentDto;
import com.project.studentManagement.service.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@PostMapping
	public ResponseEntity<StudentDto> createStudent(StudentDto studentDto) {
		StudentDto saved = studentServiceImpl.createStudent(studentDto);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAll(){
		List<StudentDto> students = studentServiceImpl.getAllStudents();
		return new ResponseEntity<List<StudentDto>>(students, HttpStatus.CREATED);
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable Integer id){
		StudentDto student = studentServiceImpl.getStudentById(id);
		return new ResponseEntity<StudentDto>(student, HttpStatus.CREATED);
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable Integer id, @PathVariable StudentDto studentDto){
		StudentDto updated = studentServiceImpl.updateStudent(id, studentDto);
		return new ResponseEntity<StudentDto>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("{/id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		studentServiceImpl.deleteStudent(id);
		return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.OK);
	}
	
}
