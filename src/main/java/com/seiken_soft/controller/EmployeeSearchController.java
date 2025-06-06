package com.seiken_soft.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seiken_soft.model.ShainList;
import com.seiken_soft.model.impl.EmployeeSearchModelImpl;

@Controller
@RequestMapping("/search")
public class EmployeeSearchController{
	
		
	
	@GetMapping("/") // "/search"以降のURL(GET)
	public String init(Model model) {
	
		
		return "searchEmployee"; //HTMLファイル名
	}
	
	
	@PostMapping
	public String aaa(Model model,@RequestParam ("shainName") String name, @RequestParam("shainId") String id ,HttpSession session) throws SQLException, Exception {
		
		EmployeeSearchModelImpl employeeSearchModelImpl = new EmployeeSearchModelImpl();
		
		List<ShainList> shainlist = employeeSearchModelImpl.searchPost(name,id);

		
		session.setAttribute("processList", shainlist);
		
        int border = 2;
		
		model.addAttribute("border", border);
		
		model.addAttribute("id","社員ID");
	    model.addAttribute("name", "社員名");
	    model.addAttribute("emailAddress", "Eメールアドレス");
	    model.addAttribute("process", "処理");
		    	
	    model.addAttribute("shainList",shainlist);
		
	    return "searchEmployee";
	}


	
 
}