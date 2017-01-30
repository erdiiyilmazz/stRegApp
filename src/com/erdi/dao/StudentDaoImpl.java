package com.erdi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erdi.model.Student;

@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao {

 @Autowired
 private SessionFactory sessionFactory;
 
 public void addStudent(Student student) {
   sessionFactory.getCurrentSession().saveOrUpdate(student);
 }

 @SuppressWarnings("unchecked")
 public List<Student> listStudent() {
  return (List<Student>) sessionFactory.getCurrentSession().createCriteria(Student.class).list();
 }

 public Student getStudent(int stId) {
  return (Student) sessionFactory.getCurrentSession().get(Student.class, stId);
 }

 public void deleteStudent(Student student) {
  sessionFactory.getCurrentSession().createQuery("DELETE FROM Student WHERE stId = "+ student.getStId()).executeUpdate();
 }
}