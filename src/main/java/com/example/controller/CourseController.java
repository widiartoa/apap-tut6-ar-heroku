package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	CourseService courseDAO;
	
	@RequestMapping("course/view/{id}")
	public String getCourse(@PathVariable(value="id") String id, Model model) {
		CourseModel course = courseDAO.selectCourse(id);
		if(course != null) {
			model.addAttribute("course", course);
			model.addAttribute("title", "Course View");
			return "courseview";
		}
		else {
			model.addAttribute("title", "Not Found");
			return "not-found";
		}
	}
}
