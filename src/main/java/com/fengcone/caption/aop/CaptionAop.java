package com.fengcone.caption.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.fengcone.caption.common.CodeEnum;
import com.fengcone.caption.common.Response;
import com.fengcone.caption.param.Param;

@Component
public class CaptionAop {
	private static final Logger logger = Logger.getLogger(CaptionAop.class);

	public CaptionAop() {
		System.out.println("这里进行了AOP的");
	}

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object ret = null;
		long beginTime = System.currentTimeMillis();
		try {
			System.out.println("som");
			ret = joinPoint.proceed();
		} catch (Exception e) {
			return getErrorResponse(CodeEnum.UNKNOW_ERROR.getCode(),
					CodeEnum.UNKNOW_ERROR.getMessage());
		} finally {
			System.out.println("some");
			logger.info("[Caption] request: " 
					+ " response: " + ret + ", cost: "
					+ (System.currentTimeMillis() - beginTime) + "ms");
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
