package com.fengcone.caption.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.fengcone.caption.common.CodeEnum;
import com.fengcone.caption.common.Response;
import com.fengcone.caption.param.Param;

public class ControllerAop {
	private static final Logger logger = Logger.getLogger(ControllerAop.class);

	public Object around(ProceedingJoinPoint joinPoint)
			throws Throwable {
		Object ret = null;
		long beginTime = System.currentTimeMillis();
		try {
			ret = joinPoint.proceed();
		} catch (Exception e) {
			return getErrorResponse(CodeEnum.UNKNOW_ERROR.getCode(),
					CodeEnum.UNKNOW_ERROR.getMessage());
		} finally {
			logger.info("[Caption] URI: " + " response: " + ret
					+ ", cost: " + (System.currentTimeMillis() - beginTime)
					+ "ms");
		}
		return ret;
	}

	private Response<Param> getErrorResponse(Integer code, String message) {
		//这个应该是404
		Response<Param> response = new Response<Param>();
		response.setCode(code);
		response.setMessage(message);
		return response;
	}
}
