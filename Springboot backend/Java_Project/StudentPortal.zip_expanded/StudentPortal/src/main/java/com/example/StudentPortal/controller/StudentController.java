package com.example.StudentPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.StudentPortal.model.Student;
import com.example.StudentPortal.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> listStudent = service.listAll();
		model.addAttribute("liststudent", listStudent);
		System.out.print("Get/");
		return "index";
	}

	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "new";
	}

	@GetMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student std) {
		service.save(std);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Student std = service.get(id);
		mav.addObject("student", std);
		return mav;

	}

	@DeleteMapping("/delete/{id}")
	public String deletestudent(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}

}
