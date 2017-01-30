package com.erdi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.erdi.dao.StudentDao;
import com.erdi.model.Student;

@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {

 @Autowired
 private StudentDao studentDao;
 
 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
 public void addStudent(Student student) {
  studentDao.addStudent(student);
 }
 
 public List<Student> listStudent() {
  return studentDao.listStudent();
 }

 public Student getStudent(int stid) {
  return studentDao.getStudent(stid);
 }
 
 public void deleteStudent(Student student) {
  studentDao.deleteStudent(student);
 }

}