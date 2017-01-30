package com.erdi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.erdi.bean.StudentBean;
import com.erdi.model.Student;
import com.erdi.service.StudentService;

@Controller
public class StudentController {
 
 @Autowired
 private StudentService studentService;
 
@RequestMapping(value = "/save", method = RequestMethod.POST)
public ModelAndView saveStudent(@ModelAttribute("command")StudentBean studentBean, 
   BindingResult result) {
  Student student = prepareModel(studentBean);
  studentService.addStudent(student);
  return new ModelAndView("redirect:/add.html");
 }

 @RequestMapping(value="/students", method = RequestMethod.GET)
 public ModelAndView listStudents() {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("students",  prepareListofBean(studentService.listStudent()));
  return new ModelAndView("StudentList", model);
 }
 
 @RequestMapping(value = "/add", method = RequestMethod.GET)
 public ModelAndView addStudent(@ModelAttribute("command")StudentBean studentBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("students",  prepareListofBean(studentService.listStudent()));
  return new ModelAndView("addStudent", model);
 }
 
@RequestMapping(value = "/index", method = RequestMethod.GET)
public ModelAndView welcome() {
  return new ModelAndView("index");
 }

@RequestMapping(value = "/delete", method = RequestMethod.GET)
public ModelAndView deleteStudent(@ModelAttribute("command")StudentBean studentBean,
   BindingResult result) {
  studentService.deleteStudent(prepareModel(studentBean));
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("student", null);
  model.put("students",  prepareListofBean(studentService.listStudent()));
  return new ModelAndView("addStudent", model);
 }
 
@RequestMapping(value = "/edit", method = RequestMethod.GET)
public ModelAndView editStudent(@ModelAttribute("command")StudentBean studentBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("student", prepareStudentBean(studentService.getStudent(studentBean.getId())));
  model.put("students",  prepareListofBean(studentService.listStudent()));
  return new ModelAndView("addStudent", model);
 }
 
 private Student prepareModel(StudentBean studentBean){
  Student student = new Student();
  student.setStName(studentBean.getName());
  student.setStDepartment(studentBean.getDepartment());
  student.setStSurname(studentBean.getSurname());
  student.setStTelephone(studentBean.getTelephone());
  student.setStId(studentBean.getId());
  student.setStAddress(studentBean.getAddress());
  studentBean.setId(null);
  return student;
 }
 
 private List<StudentBean> prepareListofBean(List<Student> students){
  List<StudentBean> beans = null;
  if(students != null && !students.isEmpty()){
   beans = new ArrayList<StudentBean>();
   StudentBean bean = null;
   for(Student student : students){
    bean = new StudentBean();
    bean.setId(student.getStId());
    bean.setName(student.getStName());
    bean.setSurname(student.getStSurname());
    bean.setDepartment(student.getStDepartment());
    bean.setTelephone(student.getStTelephone());
    bean.setAddress(student.getStAddress());
    beans.add(bean);
   }
  }
  return beans;
 }
 
 private StudentBean prepareStudentBean(Student student){
  StudentBean bean = new StudentBean();
  bean.setId(student.getStId());
  bean.setName(student.getStName());
  bean.setSurname(student.getStSurname());
  bean.setDepartment(student.getStDepartment());
  bean.setTelephone(student.getStTelephone());
  bean.setAddress(student.getStAddress());
  return bean;
 }
}