package com.mohibur.StudentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mohibur.StudentCrud.model.Student;
import com.mohibur.StudentCrud.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> liststudent = service.listAll();
		model.addAttribute("liststudent", liststudent);
		System.out.println("index.html is loaded");
		return "index";
	}

	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		System.out.println("new.html is loaded");
		return "new";
	}

	@PostMapping(value = "/save")
	public String saveStudent(@ModelAttribute("student") Student std) {
		service.save(std);
		System.out.println("New student added to the database");
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Student std = service.get(id);
		mav.addObject("student", std);
		System.out.println("Student of id = " + id + " will be edited.");
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deletestudent(@PathVariable(name = "id") int id) {
		service.delete(id);
		System.out.println("Student of id = " + id + " is deleted.");
		return "redirect:/";
	}
}
