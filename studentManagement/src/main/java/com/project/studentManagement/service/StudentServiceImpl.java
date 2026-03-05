package com.project.studentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.studentManagement.dto.StudentDto;
import com.project.studentManagement.entity.Student;
import com.project.studentManagement.exception.ResourceNotFoundException;
import com.project.studentManagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub
		Student s = modelMapper.map(studentDto, Student.class);
		
		System.out.println(studentDto.getName());
		
		Student saved = studentRepository.save(s);
		
		return modelMapper.map(saved, StudentDto.class);
	}

	@Override
	public StudentDto getStudentById(Integer id) {
		// TODO Auto-generated method stub
		Student s = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found"));
		
		return modelMapper.map(s, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();
		
		return students.stream()
				.map(s -> modelMapper.map(s, StudentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found"));
		
		studentRepository.deleteById(id);
		
	}

	@Override
	public StudentDto updateStudent(Integer id, StudentDto studentDto) {
		// TODO Auto-generated method stub
		Student s = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found"));
		s.setName(studentDto.getName());
		s.setEmail(studentDto.getEmail());
		s.setCourse(studentDto.getCourse());
		
		Student updated = studentRepository.save(s);
		
		return modelMapper.map(updated, StudentDto.class);
	}

}
