package com.project.studentManagement.service;

import java.util.List;

import com.project.studentManagement.dto.StudentDto;

public interface StudentService {

	StudentDto createStudent(StudentDto studentDto);
	StudentDto getStudentById(Integer id);
	List<StudentDto> getAllStudents();
	StudentDto updateStudent(Integer id, StudentDto studentDto);
	void deleteStudent(Integer id);
}
