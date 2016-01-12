package com.fengcone.caption.aop;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.codehaus.jackson.map.ObjectMapper;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.util.ThreadLocalUtil;

public class ApiAop {
	private static final Logger logger = Logger.getLogger(ApiAop.class);
	private static ObjectMapper mapper = new ObjectMapper();

	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object ret = null;
		long beginTime = System.currentTimeMillis();
		try {
			ret = joinPoint.proceed();
		} catch (Exception e) {
			// return getErrorResponse(CodeEnum.UNKNOW_ERROR.getCode(),
			// CodeEnum.UNKNOW_ERROR.getMessage());
		} finally {
			logger.info("[Caption] URI: " + " response: " + ret + ", cost: "
					+ (System.currentTimeMillis() - beginTime) + "ms");
		}
	}
}
