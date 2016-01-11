package com.fengcone.caption.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.param.ChooseData;
import com.fengcone.caption.service.EditService;

@Controller
public class EditController {
	
	@Autowired
	EditService editService;
	
	@RequestMapping("test")
	public void test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().write("xxxx");
	}
	@RequestMapping("choos")
	public void chooseMovie(HttpServletRequest request,HttpServletResponse response){
	}
	
	@RequestMapping("movie/data")
	@ResponseBody
	public Response<ChooseData> getMovieData(){
		return editService.choose();
	}
}


