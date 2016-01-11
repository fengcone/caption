package com.fengcone.caption.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.param.Param;

public class ApiAop {
	private static final Logger logger = Logger.getLogger(ApiAop.class);
	public ApiAop(){
		System.out.println("something apiapo");
	}
	public Object around(ProceedingJoinPoint joinPoint,
			HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		Object ret = null;
		long beginTime = System.currentTimeMillis();
		try {
			response.getWriter().write("hahahh");
			ret = joinPoint.proceed();
			return ret;
		} catch (Exception e) {
			response.getWriter().write("hahahh");
//			return getErrorResponse(CodeEnum.UNKNOW_ERROR.getCode(),
//					CodeEnum.UNKNOW_ERROR.getMessage());
		} finally {
			logger.info("[Caption] URI: " + request.getRequestURL()
					+ " response: " + ret + ", cost: "
					+ (System.currentTimeMillis() - beginTime) + "ms");
		}
		return ret;
	}

	private Response<Param> getErrorResponse(Integer code, String message) {
		// 这个应该是404
		Response<Param> response = new Response<Param>();
		response.setCode(code);
		response.setMessage(message);
		return response;
	}
}
