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
	public static void main(String[] args) {
		String xx ="dgfhdhg";
		xx.substring(1, xx.length());
		System.out.println(xx);
	}
}
