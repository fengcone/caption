package com.fengcone.caption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.param.ChooseData;
import com.fengcone.caption.service.EditService;

@Controller
public class EditApi {
	@Autowired
	EditService service;
	@RequestMapping("choose")
	public Response<ChooseData> getMovieData(){
		System.out.println("soe");
		return service.choose();
	}
}
