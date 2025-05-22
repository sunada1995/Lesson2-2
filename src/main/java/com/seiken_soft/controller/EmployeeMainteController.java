package com.seiken_soft.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.seiken_soft.model.ShainList;

@Controller
public class EmployeeMainteController {

	@PostMapping("/mainte")
	public ModelAndView viewNextPage(@RequestParam(name = "shainId", required = false) String shainId) throws SQLException, Exception {
		List<ShainList> shainList = shainId(shainId);
		
		ModelAndView model = new ModelAndView();
		model.addObject("shainList",shainList);
		model.setViewName("mainteEmployee");
		return model;
	}
	

	public List<ShainList> shainId(String shainId) throws SQLException, Exception {
		
		
		EmployeeSearchController employeeSearchController = new EmployeeSearchController();
		List<ShainList> shainList = employeeSearchController.searchPost("", shainId);
		return shainList;
		
	}
}
