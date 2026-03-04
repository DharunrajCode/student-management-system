package com.project.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.studentManagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
