package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello123";
	}
	

//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value = "name") String name, Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}

//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value = "name", required = false) String name, Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}
	
//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}
	
//	@RequestMapping("/greeting/{name}")
//	public String greetingPath(@PathVariable String name, Model model) {
//		model.addAttribute("name", name);
//		
//		return "greeting";
//	}
	
	@RequestMapping(value = {"/greeting", "/greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String multiplication(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
		model.addAttribute("a_display", a);
		model.addAttribute("b_display", b);
		int c = a * b;
		model.addAttribute("c_display", c);
		
		return "perkalian";
		
		
	}
}
