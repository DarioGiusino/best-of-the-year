package org.java.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BestOfTheYearController {

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("name", "Dario");
		return "index";
	}
}
