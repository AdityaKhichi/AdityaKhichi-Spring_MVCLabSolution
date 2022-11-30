package com.college.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.college.entity.Student;
import com.college.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String findAllStudent(Map<String,List<Student>> map) {
		List<Student> students=studentService.findAllStudents();
		map.put("student",students);
		return "studentlist";
	}
	
	@PostMapping("/save")
	public String saveOrUpdate(Student student) {
		Student savedStudent=null;
		System.out.println(student);
		if(student.getId()!=0) {
			savedStudent=studentService.findStudentById(student.getId());
			savedStudent.setName(student.getName());
			savedStudent.setCountry(student.getCountry());
			savedStudent.setDepartment(student.getDepartment());
		}
		else 
			savedStudent=student;
		
		this.studentService.saveOrUpdate(savedStudent);
		return "redirect:/student/list";		
	}
	
	@GetMapping("/{id}")
	public String delete(@PathVariable int id) {
		this.studentService.delete(id);
		return "redirect:/student/list";
	}
	
	@GetMapping("/add")
	public String show(Model model) {
		model.addAttribute("student", new Student());
		return "studentform";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model,@PathVariable int id) {
		Student student=this.studentService.findStudentById(id);
		model.addAttribute(student);
		return "studentform";
	}
	


}
