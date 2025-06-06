/**
 * 
 */
package com.seiken_soft.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.seiken_soft.model.ShainList;
import com.seiken_soft.model.impl.EmployeeSearchModelImpl;
import com.seiken_soft.model.impl.EmployeeUpdateModelImpl;

/**
 * 
 */
@Controller
@RequestMapping("/update")
public class EmployeeUpdateController {
	
	/**
	 * コネクション情報を返却する
	 * @return コネクション情報
	 * @throws SQLException
	 */
	
	//戻るボタン押下時
	//paramsはname
	@RequestMapping(params = "backPage",method = RequestMethod.POST)
	public ModelAndView backPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("searchEmployee");
		return model;
	}
	
	
	//ダイアログOKボタン押下時
	//paramsはname
	@RequestMapping(params = "update",method = RequestMethod.POST)
	public String update
	(Model model, @RequestParam (name="shainName", required = false) String shainName,@RequestParam (name="shainId", required = false) String shainId,@RequestParam (name="emailAddress", required = false) String emailAddress) throws Exception {
				
		EmployeeUpdateModelImpl employeeUpdateModelImpl = new EmployeeUpdateModelImpl();
		employeeUpdateModelImpl.update(shainName, shainId, emailAddress,employeeUpdateModelImpl.getCon());	
		EmployeeSearchModelImpl employeeSearchModelImpl = new EmployeeSearchModelImpl();
		List<ShainList> shainList = employeeSearchModelImpl.searchPost("","");
		model.addAllAttributes(shainList);
	    
	    return "searchEmployee";
    }
}
 