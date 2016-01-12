package com.fengcone.caption.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.param.ChooseData;
import com.fengcone.caption.param.Param;
import com.fengcone.caption.service.EditService;
import com.fengcone.caption.util.ThreadLocalUtil;

@Controller
public class EditApi {
	@Autowired
	EditService service;
	private static ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value="choosex",method={RequestMethod.POST,RequestMethod.GET})
	public void getMovieData(HttpServletResponse response) throws Exception{
		Response<ChooseData> data = service.choose();
		String json = mapper.writeValueAsString(data);
		response.getWriter().write(json);
	}
}
