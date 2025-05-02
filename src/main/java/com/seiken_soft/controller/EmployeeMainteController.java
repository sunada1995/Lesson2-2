package com.seiken_soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeMainteController {

	@GetMapping("/mainte")
	public ModelAndView viewNextPage(@RequestParam ("shainName") String shainId) {
		shainId(shainId);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("mainteEmployee");
		return model;
	}
	

	public String shainId(Model model,String shainId) {
		
	}
}
