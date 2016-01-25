package com.fengcone.caption.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.domain.Caption;
import com.fengcone.caption.param.ChooseDTO;
import com.fengcone.caption.param.NextCaptionParam;
import com.fengcone.caption.service.EditService;

@Controller
public class EditController {

	@Autowired
	EditService editService;
	
	private ObjectMapper mapper= new ObjectMapper();

	@RequestMapping("choose")
	public ModelAndView chooseMovie(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("choose");
		Response<ChooseDTO> response2 = editService.choose();
		mv.addObject("movies", response2.getData().getMovies());
		return mv;
	}
	@RequestMapping("edit")
	public ModelAndView editPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("edit");
		NextCaptionParam param = mapper.readValue(request.getAttribute("param").toString(), NextCaptionParam.class);
		param.setOrderNo(1);
		Response<Caption> data = editService.nextCaption(param);
		mv.addObject("caption", data.getData());
		return mv;
	}
}
