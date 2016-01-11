package com.fengcone.caption.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.fengcone.caption.common.CodeEnum;
import com.fengcone.caption.common.Response;
import com.fengcone.caption.param.Param;

public class CaptionAop {
	private static final Logger logger = Logger.getLogger(CaptionAop.class);

	public CaptionAop() {
		System.out.println("这里进行了AOP的");
	}

	public Object around(ProceedingJoinPoint joinPoint,
			HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		Object ret = null;
		long beginTime = System.currentTimeMillis();
		try {
			ret = joinPoint.proceed();
		} catch (Exception e) {
			return getErrorResponse(CodeEnum.UNKNOW_ERROR.getCode(),
					CodeEnum.UNKNOW_ERROR.getMessage());
		} finally {
			logger.info("[Caption] URI: " +request.getRequestURL()+ " response: " + ret
					+ ", cost: " + (System.currentTimeMillis() - beginTime)
					+ "ms");
		}
		return ret;
	}

	private Response<Param> getErrorResponse(Integer code, String message) {
		Response<Param> response = new Response<Param>();
		response.setCode(code);
		response.setMessage(message);
		return response;
	}
}
