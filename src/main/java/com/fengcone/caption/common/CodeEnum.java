package com.fengcone.caption.common;

public enum CodeEnum {
	SUCCESS(1000, "成功"), 
	UNKNOW_ERROR(9999, "内部错误");
	private CodeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;
	private String message;

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
}
