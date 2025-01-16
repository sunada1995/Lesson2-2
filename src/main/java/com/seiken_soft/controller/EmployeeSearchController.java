package com.seiken_soft.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
public class EmployeeSearchController {
	
	//private static String DB_URL = "jdbc:mysql://localhost:3306/Lesson02DB?allowPublicKeyRetrieval=true&amp;useSSL=false&amp;serverTimezone=GMT&amp;useUnicode=yes&amp;characterEncoding=UTF-8";
	private static String DB_URL = "jdbc:mysql://localhost:3306/Lesson02DB";
	private static String DB_USER = "root";
	private static String DB_PASS = "sunadaru4562";
	
	/**
	 * コネクション情報を返却する
	 * @return コネクション情報
	 * @throws SQLException
	 */
	public Connection getCon() throws SQLException{
		try {
			// JDBCドライバーのクラスをロード ①
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException("JDBCドライバーのロードに失敗しました", e);
		}

		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); // ②
	}
		
	
	@GetMapping("/") // "/search"以降のURL(GET)
	public String init(Model model) {
	
		
		return "searchEmployee"; //HTMLファイル名
	}
	
	
	@PostMapping
	public String aaa(Model model,@RequestParam ("shainName") String name, @RequestParam("shainId") String id ) throws SQLException, Exception {
		
		List<ShainList> shainlist = searchPost(name,id);
		
		model.addAttribute("id","社員ID");
	    model.addAttribute("name", "社員名");
	    model.addAttribute("emailAddress", "Eメールアドレス");
	    model.addAttribute("process", "処理");
		    	
	    model.addAttribute("shainList",shainlist);
		   	          
	    
	    return "searchEmployee";
	}
	
	public List<ShainList> searchPost(String shainName,String shainId) throws SQLException, Exception {
		     
		//DBコネクション
		
		EmployeeSearchModelImpl employeeSearchModelImpl = new EmployeeSearchModelImpl();
		List<ShainList> shainList = employeeSearchModelImpl.findAll(shainName,shainId,getCon());		  
		
	    return shainList;
	    
	}
	
 
}