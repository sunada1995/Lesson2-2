/**
 * 
 */
package com.seiken_soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView update() {
	    ModelAndView model = new ModelAndView();
	    model.setViewName("searchEmployee");
	    return model;
    }
}
