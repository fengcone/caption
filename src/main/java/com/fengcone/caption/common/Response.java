package com.fengcone.caption.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fengcone.caption.param.Param;

public class Response<T extends Param> implements Serializable {
	private static final long serialVersionUID = 579254840151L;
	private Integer code = CodeEnum.SUCCESS.getCode();
	private String message = CodeEnum.SUCCESS.getMessage();
	private T data;

	public void setCodeEnum(CodeEnum codeEnum) {
		this.code = codeEnum.getCode();
		this.message = codeEnum.getMessage();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
