package com.fengcone.caption.aop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.fengcone.caption.util.ThreadLocalUtil;

public class ResponseFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (response instanceof HttpServletResponse) {
			response.setCharacterEncoding("utf-8");
			ThreadLocalUtil.setResponse((HttpServletResponse) response);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
