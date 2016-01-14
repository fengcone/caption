package com.fengcone.caption.aop;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.CollectionUtils;

public class ApiAop {
	private static final Logger logger = Logger.getLogger(ApiAop.class);

	public void around(ProceedingJoinPoint joinPoint,
			HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		long beginTime = System.currentTimeMillis();
		try {
			request.setAttribute("param", this.getParam(request));
			joinPoint.proceed();
		} catch (Exception e) {
			logger.info("[Caption] Error: " + e.getMessage() + ", cost: "
					+ (System.currentTimeMillis() - beginTime) + "ms");
			response.getWriter().write(e.getMessage());
		} finally {
			logger.info("[Caption] URI: " + request.getRequestURI() + ""
					+ ", cost: " + (System.currentTimeMillis() - beginTime)
					+ "ms");
		}
	}

	private String getParam(HttpServletRequest request) throws Exception {
		Map<String, String[]> map = request.getParameterMap();
		String paramStr = null;
		if (!CollectionUtils.isEmpty(map)) {
			paramStr = "{";
			for (Entry<String, String[]> entry : map.entrySet()) {
				String value = entry.getValue()[0];
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
				paramStr = paramStr + "\"" + entry.getKey() + "\":\"" + value
						+ "\",";
			}
			paramStr = paramStr.substring(0, paramStr.length() - 1) + "}";
		}
		return paramStr;
	}
}
