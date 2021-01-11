package com.koreait.petshop.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.model.product.service.TopCategoryService;

@Controller
public class MainController {
	@Autowired
	private TopCategoryService topCategoryService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		List topList = topCategoryService.selectAll();
		mav.addObject("topList",topList);
		mav.setViewName("index"); //메인페이지 
		return mav;
	}
}