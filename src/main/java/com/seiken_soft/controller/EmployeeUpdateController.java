/**
 * 
 */
package com.seiken_soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.seiken_soft.model.impl.EmployeeUpdateModelImpl;

/**
 * 
 */
@Controller
@RequestMapping("/update")
public class EmployeeUpdateController {

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
	public ModelAndView update
	(@RequestParam (name="shainName", required = false) String shainName,@RequestParam (name="shainId", required = false) String shainId,@RequestParam (name="emailAddress", required = false) String emailAddress) throws Exception {
		EmployeeUpdateModelImpl employeeUpdateModelImpl = new EmployeeUpdateModelImpl();
		employeeUpdateModelImpl.update(shainName, shainId, emailAddress, null);
		ModelAndView model = new ModelAndView();
	    model.setViewName("searchEmployee");
	    return model;
    }
}
