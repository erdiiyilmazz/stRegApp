package com.erdi.dao;

import java.util.List;

import com.erdi.model.Student;

public interface StudentDao {
	 public void addStudent(Student student);

	 public List<Student> listStudent();
	 
	 public Student getStudent(int stid);
	 
	 public void deleteStudent(Student student);
}
