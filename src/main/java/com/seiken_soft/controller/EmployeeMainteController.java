package com.seiken_soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeMainteController {

	@GetMapping("/mainte")
	public ModelAndView viewNextPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("mainteEmployee");
		return model;
	}
	

}
