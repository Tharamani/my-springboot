package com.javalearning.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoThymeleafController {

	//create a mapping for hello
	@GetMapping("/hello")
	public String sayHello(Model model) {
		
		model.addAttribute("serverDate", new java.util.Date());
		return "helloworld";
	}
}
 