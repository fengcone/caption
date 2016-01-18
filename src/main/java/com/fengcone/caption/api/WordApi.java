package com.fengcone.caption.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fengcone.caption.param.GetMeanParam;
import com.fengcone.caption.service.WordService;

@Controller
public class WordApi {
	@Autowired
	WordService wordService;

	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping("get/mean")
	public void getMean(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GetMeanParam param = mapper.readValue(request.getAttribute("param")
				.toString(), GetMeanParam.class);
		wordService.getMean(param);
	}

}
