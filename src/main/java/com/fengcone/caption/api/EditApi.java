package com.fengcone.caption.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		AddPackageParam param = (AddPackageParam) this.getParam(request,
				AddPackageParam.class);
		Response<Param> data = service.addPackage(param);
		response.getWriter().write(mapper.writeValueAsString(data));
	}

	private Param getParam(HttpServletRequest request,
			Class<? extends Param> target) {
		Map map = request.getParameterMap();
		Object obj = null;
		try {
			obj = target.newInstance();
			Method[] methods = target.getDeclaredMethods();
			for (Method method : methods) {
				String name = method.getName();
				if (name.startsWith("set")) {
					name = name.substring(3, name.length());
					name = name.substring(0, 1).toLowerCase()
							+ name.substring(1, name.length());
					Object object = map.get(name);
					if (object != null) {
						method.invoke(obj,
								method.getParameterTypes()[0].cast(object));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Param) obj;
	}
}
