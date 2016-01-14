package com.fengcone.caption.api;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.param.AddPackageParam;
import com.fengcone.caption.param.ChooseDTO;
import com.fengcone.caption.param.Param;
import com.fengcone.caption.service.EditService;

@Controller
public class EditApi {
	@Autowired
	EditService service;
	private static ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "choose")
	public void getMovieData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Response<ChooseDTO> data = service.choose();
		response.getWriter().write(mapper.writeValueAsString(data));
	}

	@RequestMapping("add/package")
	public void addPackage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AddPackageParam param = mapper.readValue(request.getAttribute("param")
				.toString(), AddPackageParam.class);
		Response<Param> data = service.addPackage(param);
		response.getWriter().write(mapper.writeValueAsString(data));
	}

}
