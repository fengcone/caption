package com.fengcone.caption.util;

import javax.servlet.http.HttpServletResponse;

public class ThreadLocalUtil {
	private static final ThreadLocal<HttpServletResponse> threadRes = new ThreadLocal<HttpServletResponse>();
	public static HttpServletResponse getResponse(){
		return threadRes.get();
	}
	public static void setResponse(HttpServletResponse response){
		threadRes.set(response);
	}
}
