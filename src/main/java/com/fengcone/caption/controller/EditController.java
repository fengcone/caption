package com.fengcone.caption.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fengcone.caption.service.EditService;

@Controller
public class EditController {
	
	@Autowired
	EditService editService;
	
	@RequestMapping("test")
	public void test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		editService.test();
		response.getWriter().write("xxxx");
	}
	@RequestMapping("choose")
	public ModelAndView chooseMovie(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	public void test(){
		System.out.println("something");
	}
}


