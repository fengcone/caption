package com.fengcone.caption.common;

import com.fengcone.caption.param.Param;

public class Request<T extends Param> {
	private T param;

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}
	
}
