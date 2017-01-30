package com.erdi.service;

import java.util.List;

import com.erdi.model.Student;

public interface StudentService {
	 public void addStudent(Student student);

	 public List<Student> listStudent();
	 
	 public Student getStudent(int stid);
	 
	 public void deleteStudent(Student student);
}
